package com.alfabattle.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class Loan {

  @JsonFormat(pattern = "M/d/yyyy")
  @JsonProperty("StartDate")
  private LocalDate startDate;
  @JsonProperty("Loan")
  private String loan;
  @JsonProperty("PersonId")
  private String personId;
  @JsonProperty("Amount")
  private BigDecimal amount;
  @JsonProperty("Period")
  private int period;
}