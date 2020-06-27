package com.alfabattle.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * User: @AleksandrMIM
 * Date: 27.06.2020
 * Time: 0:58
 */
@Document(indexName = "persons")
@Getter
@Setter
@ToString
public class PersonEntity {

  @Id
  private String id;
  @Field(type = FieldType.Keyword)
  private String docId;
  @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd")
  private String birthday;
  @Field(type = FieldType.Keyword)
  private String gender;
  @Field(type = FieldType.Double)
  private double salary;
  @Field(type = FieldType.Text)
  private String fio;
}
