package com.alfabattle.configuration;

import com.alfabattle.mapper.ArticleMapper;
import com.alfabattle.model.Article;
import com.alfabattle.property.JsonFileProperty;
import com.alfabattle.repository.FileRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.IndexQuery;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * User: @AleksandrMIM
 * Date: 27.06.2020
 * Time: 2:45
 */
@Slf4j
@RequiredArgsConstructor
public class SampleDataSet {

  private static final String INDEX_NAME = "blog";

  private final ElasticsearchRestTemplate template;
  private final ObjectMapper objectMapper;

  private final ArticleMapper articleMapper;
  private final FileRepository fileRepository;
  private final JsonFileProperty jsonFileProperty;

  @PostConstruct
  public void init() {
    IndexCoordinates indexCoordinates = IndexCoordinates.of(INDEX_NAME);
    if (!template.indexOps(indexCoordinates).exists()) {
      template.indexOps(indexCoordinates).create();
    }

    var queries = jsonFileProperty.getFiles()
        .stream()
        .map(url -> fileRepository.read(url, Article.class))
        .map(articleMapper::map)
        .flatMap(Collection::stream)
        .map(article -> {
          IndexQuery indexQuery = new IndexQuery();
          indexQuery.setId(article.getId());
          try {
            indexQuery.setSource(objectMapper.writeValueAsString(article));
          } catch (JsonProcessingException e) {
            logger.error(e.getMessage(), e);
          }
          return indexQuery;
        }).collect(Collectors.toList());

    if (queries.size() > 0) {
      template.bulkIndex(queries, indexCoordinates);
    }

    template.indexOps(indexCoordinates).refresh();
  }
}
