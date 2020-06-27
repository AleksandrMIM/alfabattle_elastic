package com.alfabattle.dao;

import com.alfabattle.entity.PersonEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.Optional;

/**
 * User: @AleksandrMIM
 * Date: 26.06.2020
 * Time: 21:08
 */
public interface PersonDao extends ElasticsearchRepository<PersonEntity, String> {

  Optional<PersonEntity> getByDocId(String docId);
}
