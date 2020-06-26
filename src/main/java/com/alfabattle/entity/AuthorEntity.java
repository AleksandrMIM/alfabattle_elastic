package com.alfabattle.entity;

import lombok.*;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * User: @AleksandrMIM
 * Date: 27.06.2020
 * Time: 0:59
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AuthorEntity {

  @Field(type = FieldType.Text)
  private String name;
}
