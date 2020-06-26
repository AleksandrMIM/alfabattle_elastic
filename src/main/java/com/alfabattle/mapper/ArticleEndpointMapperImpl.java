package com.alfabattle.mapper;

import com.alfabattle.api.TestRequest;
import com.alfabattle.api.TestResponse;
import com.alfabattle.model.Article;
import com.alfabattle.model.ArticlesItem;
import com.alfabattle.model.AuthorsItem;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.stream.Collectors;

/**
 * User: @AleksandrMIM
 * Date: 26.06.2020
 * Time: 21:49
 */
@Component
public class ArticleEndpointMapperImpl implements ArticleEndpointMapper {

  @Override
  public @NotNull Article map(@NotNull TestRequest request) {
    Article article = new Article();
    article.setArticles(
        Collections.singletonList(
            new ArticlesItem(
                request.getTitle(),
                request.getAuthorName()
                    .stream()
                    .map(AuthorsItem::new)
                    .collect(Collectors.toList()),
                request.getTag()
            )
        )
    );
    return article;
  }

  @Override
  public @NotNull TestResponse map(@NotNull Long count) {
    TestResponse response = new TestResponse();
    response.setCount(count);
    return response;
  }
}
