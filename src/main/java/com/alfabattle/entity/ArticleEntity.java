package com.alfabattle.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;

import java.util.List;

/**
 * User: @AleksandrMIM
 * Date: 27.06.2020
 * Time: 0:58
 */
@Document(indexName = "blog")
@Getter
@Setter
@ToString
public class ArticleEntity {

  @Id
  private String id;
  @MultiField(
      mainField = @Field(type = FieldType.Text, fielddata = true),
      otherFields = {@InnerField(suffix = "verbatim", type = FieldType.Keyword)})
  private String title;
  @Field(type = FieldType.Nested, includeInParent = true)
  private List<AuthorEntity> authors;
  @Field(type = FieldType.Keyword)
  private String[] tags;
}
