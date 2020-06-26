package com.alfabattle.mapper;

import com.alfabattle.api.TestRequest;
import com.alfabattle.api.TestResponse;
import com.alfabattle.model.Article;
import org.jetbrains.annotations.NotNull;

/**
 * User: @AleksandrMIM
 * Date: 26.06.2020
 * Time: 21:48
 */
public interface ArticleEndpointMapper {

  @NotNull
  Article map(@NotNull TestRequest request);

  @NotNull
  TestResponse map(@NotNull Long count);
}
