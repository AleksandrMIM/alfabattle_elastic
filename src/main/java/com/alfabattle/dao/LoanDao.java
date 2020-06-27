package com.alfabattle.dao;

import com.alfabattle.entity.LoanEntity;
import com.alfabattle.entity.PersonEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;
import java.util.Optional;

/**
 * User: @AleksandrMIM
 * Date: 26.06.2020
 * Time: 21:08
 */
public interface LoanDao extends ElasticsearchRepository<LoanEntity, String> {

  List<LoanEntity> findByDocumentId(String documentId);
}
