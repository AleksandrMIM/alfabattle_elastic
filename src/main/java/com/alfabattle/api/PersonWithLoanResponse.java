package com.alfabattle.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.ALWAYS)
public class PersonWithLoanResponse {

  private Long id;
  @JsonProperty("docid")
  private String docId;
  @JsonFormat(pattern = "dd.MM.yyyy")
  private LocalDate birthday;
  private String gender;
  private double salary;
  private String fio;
  private List<LoanResponse> loanResponses;
}