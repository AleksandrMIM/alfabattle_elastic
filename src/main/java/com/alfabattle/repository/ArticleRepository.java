package com.alfabattle.repository;

import com.alfabattle.model.Article;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

/**
 * User: @AleksandrMIM
 * Date: 26.06.2020
 * Time: 21:11
 */
public interface ArticleRepository {

  void save(@NotNull Article article);

  @NotNull
  Optional<Long> findByAuthorName(@NotNull String name);
}
