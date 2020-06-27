package com.alfabattle.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PersonResponse {

  @JsonProperty("docid")
  private String docId;
  private String birthday;
  private String gender;
  private double salary;
  private String fio;
  private List<LoanResponse> loanResponses;
}