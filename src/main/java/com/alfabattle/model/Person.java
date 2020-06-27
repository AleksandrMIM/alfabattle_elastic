package com.alfabattle.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class Person {

  @JsonProperty("ID")
  private String id;
  @JsonProperty("DocId")
  private String docId;
  @JsonProperty("FIO")
  private String fio;
  @JsonProperty("Birthday")
  @JsonFormat(pattern = "M/d/yyyy")
  private LocalDate birthday;
  @JsonProperty("Salary")
  private BigDecimal salary;
  @JsonProperty("Gender")
  private String gender;
}