package com.alfabattle.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * User: @AleksandrMIM
 * Date: 27.06.2020
 * Time: 0:59
 */
@Document(indexName = "loans")
@Getter
@Setter
@ToString
public class LoanEntity {

  @Id
  private String loan;
  @Field(type = FieldType.Integer)
  private int amount;
  @Field(type = FieldType.Integer)
  private int period;
  @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd")
  private String startDate;
  @Field(type = FieldType.Keyword)
  private String personId;
  @Field(type = FieldType.Keyword)
  private String documentId;
}
