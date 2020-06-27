package com.alfabattle.service;

import com.alfabattle.dao.LoanDao;
import com.alfabattle.dao.PersonDao;
import com.alfabattle.entity.CreditHistoryEntity;
import com.alfabattle.entity.LoanEntity;
import com.alfabattle.entity.PersonEntity;
import com.alfabattle.mapper.LoanMapper;
import com.alfabattle.model.Loans;
import com.alfabattle.property.JsonFileProperty;
import com.alfabattle.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * User: @AleksandrMIM
 * Date: 27.06.2020
 * Time: 18:10
 */
@Service
@RequiredArgsConstructor
public class LoanServiceImpl implements LoanService {

  private static final String INDEX_NAME = "loans";

  private final ElasticsearchRestTemplate template;

  private final PersonDao personDao;
  private final LoanDao loanDao;
  private final JsonFileProperty jsonFileProperty;
  private final FileRepository fileRepository;
  private final LoanMapper loanMapper;

  @Override
  public void load() {
    IndexCoordinates indexCoordinates = IndexCoordinates.of(INDEX_NAME);
    if (!template.indexOps(indexCoordinates).exists()) {
      template.indexOps(indexCoordinates).create();
    }

    loanDao.saveAll(fileRepository.read(jsonFileProperty.getLoans(), Loans.class)
        .getLoans()
        .stream()
        .map(loan -> {
          var docId = personDao.findById(loan.getPersonId())
              .map(PersonEntity::getDocId)
              .orElse("");
          return loanMapper.map(loan, docId);
        })
        .collect(Collectors.toList()));

    template.indexOps(indexCoordinates).refresh();
  }

  @Override
  public Optional<LoanEntity> getByDocId(String docId) {
    return loanDao.findById(docId);
  }

  @Override
  public List<LoanEntity> getClosed() {
    var result = new ArrayList<LoanEntity>();
    LocalDate localDate = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
    loanDao.findAll()
        .forEach(loanEntity -> {
          LocalDate startDate = loanMapper.map(loanEntity.getStartDate());
          LocalDate closeDate = startDate.plusMonths(loanEntity.getPeriod());
          if (closeDate.isBefore(localDate)) {
            result.add(loanEntity);
          }
        });
    return result;
  }

  @Override
  public CreditHistoryEntity getCreditHistory(String docId) {
    List<LoanEntity> loans = loanDao.findByDocumentId(docId);

    CreditHistoryEntity creditHistoryEntity = new CreditHistoryEntity();
    creditHistoryEntity.setCountLoan(loans.size());
    creditHistoryEntity.setSumAmountLoans(loans
        .stream()
        .mapToDouble(LoanEntity::getAmount)
        .sum());
    creditHistoryEntity.setLoans(loans);
    return creditHistoryEntity;
  }

  @Override
  public List<LoanEntity> getByDocumentId(String docId) {
    return loanDao.findByDocumentId(docId);
  }
}
