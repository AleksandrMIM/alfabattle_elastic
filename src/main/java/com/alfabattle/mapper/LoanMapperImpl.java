package com.alfabattle.mapper;

import com.alfabattle.entity.LoanEntity;
import com.alfabattle.model.Loan;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * User: @AleksandrMIM
 * Date: 27.06.2020
 * Time: 2:32
 */
@Component
public class LoanMapperImpl implements LoanMapper {

  private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

  private final BigDecimal oneHundred = new BigDecimal("100");

  @Override
  public LoanEntity map(Loan loan, String docId) {
    LoanEntity loanEntity = new LoanEntity();
    loanEntity.setLoan(loan.getLoan());
    loanEntity.setDocumentId(docId);
    loanEntity.setPersonId(loan.getPersonId());
    loanEntity.setPeriod(loan.getPeriod() * 12);
    loanEntity.setStartDate(dateTimeFormatter.format(loan.getStartDate()));
    loanEntity.setAmount(loan.getAmount()
        .multiply(oneHundred)
        .setScale(0, RoundingMode.HALF_UP)
        .intValue()
    );

    return loanEntity;
  }

  @Override
  public LocalDate map(String startDate) {
    return LocalDate.parse(startDate, dateTimeFormatter);
  }
}
