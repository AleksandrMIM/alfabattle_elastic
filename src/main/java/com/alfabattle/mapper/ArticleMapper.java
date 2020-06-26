package com.alfabattle.mapper;

import com.alfabattle.entity.ArticleEntity;
import com.alfabattle.model.Article;

import java.util.List;

/**
 * User: @AleksandrMIM
 * Date: 26.06.2020
 * Time: 11:45
 */
public interface ArticleMapper {

  List<ArticleEntity> map(Article article);
}
