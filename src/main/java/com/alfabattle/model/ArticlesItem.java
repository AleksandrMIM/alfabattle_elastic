package com.alfabattle.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArticlesItem {

  private String title;
  private List<AuthorsItem> authors;
  private List<String> tags;
}