package com.alfabattle.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * User: @AleksandrMIM
 * Date: 27.06.2020
 * Time: 18:44
 */
@Getter
@Setter
public class CreditHistoryEntity {

  private int countLoan;
  private double sumAmountLoans;
  private List<LoanEntity> loans;
}
