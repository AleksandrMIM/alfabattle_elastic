package com.alfabattle.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoanResponse {

  private String loan;
  private int amount;
  private int period;
  private String document;
  @JsonProperty("startdate")
  private String startDate;
}