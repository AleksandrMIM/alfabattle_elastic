package com.alfabattle.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Article {

  private List<ArticlesItem> articles;
}