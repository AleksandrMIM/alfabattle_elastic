package com.alfabattle.configuration;

import com.alfabattle.mapper.ArticleMapper;
import com.alfabattle.property.JsonFileProperty;
import com.alfabattle.repository.FileRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * User: @AleksandrMIM
 * Date: 27.06.2020
 * Time: 2:05
 */
@Configuration
@EnableElasticsearchRepositories
@EnableConfigurationProperties(JsonFileProperty.class)
public class ElasticConfiguration {

//  @Value("${elasticsearch.uri}")
//  private String uri;
//
//  @Bean
//  public RestHighLevelClient client() {
//    ClientConfiguration clientConfiguration = ClientConfiguration.builder()
//        .connectedTo(uri)
//        .withConnectTimeout(10_000)
//        .withSocketTimeout(30_000)
//        .build();
//
//    return RestClients.create(clientConfiguration)
//        .rest();
//  }
//
//  @Bean
//  public ElasticsearchOperations elasticsearchTemplate() {
//    return new ElasticsearchRestTemplate(client());
//  }

  @Bean
  public SampleDataSet sampleDataSet(ElasticsearchRestTemplate restTemplate,
                                     ObjectMapper objectMapper,
                                     ArticleMapper articleMapper,
                                     FileRepository fileRepository,
                                     JsonFileProperty jsonFileProperty) {
    return new SampleDataSet(restTemplate, objectMapper, articleMapper, fileRepository, jsonFileProperty);
  }
}
