package com.alfabattle.mapper;

import com.alfabattle.entity.ArticleEntity;
import com.alfabattle.entity.AuthorEntity;
import com.alfabattle.model.Article;
import com.alfabattle.model.AuthorsItem;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * User: @AleksandrMIM
 * Date: 27.06.2020
 * Time: 2:32
 */
@Component
public class ArticleMapperImpl implements ArticleMapper {

  @Override
  public List<ArticleEntity> map(Article article) {
    return article.getArticles()
        .stream()
        .map(articlesItem -> {
          ArticleEntity articleEntity = new ArticleEntity();
          articleEntity.setId(UUID.randomUUID().toString());
          articleEntity.setTitle(articlesItem.getTitle());
          articleEntity.setAuthors(articlesItem.getAuthors()
              .stream()
              .map(AuthorsItem::getName)
              .map(AuthorEntity::new)
              .collect(Collectors.toList()));
          articleEntity.setTags(articlesItem.getTags().toArray(new String[0]));
          return articleEntity;
        }).collect(Collectors.toList());
  }
}
