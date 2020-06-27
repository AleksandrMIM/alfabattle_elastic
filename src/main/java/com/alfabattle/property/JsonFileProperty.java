package com.alfabattle.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * User: @AleksandrMIM
 * Date: 27.06.2020
 * Time: 1:46
 */
@Getter
@Setter
@ConfigurationProperties("json")
public class JsonFileProperty {

  private String loans;
  private String persons;
}
