package com.alfabattle.dao;

import com.alfabattle.entity.ArticleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.Optional;

/**
 * User: @AleksandrMIM
 * Date: 26.06.2020
 * Time: 21:08
 */
public interface ArticleDao extends ElasticsearchRepository<ArticleEntity, String> {

  Optional<Long> countByAuthorsName(String name);

  Page<ArticleEntity> findByAuthorsName(String name, Pageable pageable);

  @Query("{\"bool\": {\"must\": [{\"match\": {\"authors.name\": \"?0\"}}]}}")
  Page<ArticleEntity> findByAuthorsNameUsingCustomQuery(String name, Pageable pageable);

  @Query("{\"bool\": {\"must\": {\"match_all\": {}}, \"filter\": {\"term\": {\"tags\": \"?0\" }}}}")
  Page<ArticleEntity> findByFilteredTagCustomQuery(String tag, Pageable pageable);

  @Query("{\"bool\": {\"must\": {\"match\": {\"authors.name\": \"?0\"}}, \"filter\": {\"term\": {\"tags\": \"?1\" }}}}")
  Page<ArticleEntity> findByAuthorsNameAndFilterTagCustomQuery(String name, String tag, Pageable pageable);
}
