package com.alfabattle.service;

import com.alfabattle.dao.PersonDao;
import com.alfabattle.entity.PersonEntity;
import com.alfabattle.mapper.PersonMapper;
import com.alfabattle.model.Persons;
import com.alfabattle.property.JsonFileProperty;
import com.alfabattle.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * User: @AleksandrMIM
 * Date: 27.06.2020
 * Time: 16:52
 */
@Slf4j
@Service
@RequiredArgsConstructor
@EnableConfigurationProperties(JsonFileProperty.class)
public class PersonServiceImpl implements PersonService {

  private static final String INDEX_NAME = "persons";

  private final ElasticsearchRestTemplate template;

  private final PersonDao personDao;
  private final JsonFileProperty jsonFileProperty;
  private final FileRepository fileRepository;
  private final PersonMapper personMapper;

  @Override
  public void load() {
    IndexCoordinates indexCoordinates = IndexCoordinates.of(INDEX_NAME);
    if (!template.indexOps(indexCoordinates).exists()) {
      template.indexOps(indexCoordinates).create();
    }

    personDao.saveAll(fileRepository.read(jsonFileProperty.getPersons(), Persons.class)
        .getPersons()
        .stream()
        .map(personMapper::map)
        .collect(Collectors.toList()));

    template.indexOps(indexCoordinates).refresh();
  }

  @Override
  public Optional<PersonEntity> getByDocId(String docId) {
    return personDao.getByDocId(docId);
  }

  @Override
  public List<PersonEntity> getPersonSortById() {
    List<PersonEntity> persons = new ArrayList<>();
    personDao.findAll(Sort.by(Sort.Direction.DESC, "birthday")).forEach(persons::add);
    return persons;
  }
}
