package com.alfabattle.use_case;

import com.alfabattle.api.TestRequest;
import com.alfabattle.api.TestResponse;
import com.alfabattle.model.Article;
import com.alfabattle.mapper.ArticleEndpointMapper;
import com.alfabattle.property.JsonFileProperty;
import com.alfabattle.repository.ArticleRepository;
import com.alfabattle.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

/**
 * User: @AleksandrMIM
 * Date: 26.06.2020
 * Time: 12:19
 */
@Service
@RequiredArgsConstructor
public class ArticleUseCaseImpl implements ArticleUseCase {

  private final ArticleRepository articleRepository;
  private final ArticleEndpointMapper articleEndpointMapper;

  @Override
  public @NotNull
  TestResponse saveArticle(@NotNull TestRequest testRequest) {
    articleRepository.save(articleEndpointMapper.map(testRequest));
    return articleRepository.findByAuthorName(testRequest.getAuthorName().get(0))
        .map(articleEndpointMapper::map)
        .orElse(new TestResponse());
  }
}
