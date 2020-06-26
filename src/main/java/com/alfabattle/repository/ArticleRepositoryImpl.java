package com.alfabattle.repository;

import com.alfabattle.dao.ArticleDao;
import com.alfabattle.mapper.ArticleMapper;
import com.alfabattle.model.Article;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * User: @AleksandrMIM
 * Date: 26.06.2020
 * Time: 21:31
 */
@Repository
@RequiredArgsConstructor
@Slf4j
public class ArticleRepositoryImpl implements ArticleRepository {

  private final ArticleDao articleDao;
  private final ArticleMapper articleMapper;

  @Override
  public void save(@NotNull Article article) {
    articleMapper.map(article)
        .forEach(articleDao::save);
  }

  @Override
  public @NotNull Optional<Long> findByAuthorName(@NotNull String name) {
    return articleDao.countByAuthorsName(name);
  }
}
