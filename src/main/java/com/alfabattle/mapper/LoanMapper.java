package com.alfabattle.mapper;

import com.alfabattle.entity.LoanEntity;
import com.alfabattle.model.Loan;

import java.time.LocalDate;

/**
 * User: @AleksandrMIM
 * Date: 26.06.2020
 * Time: 11:45
 */
public interface LoanMapper {

  LoanEntity map(Loan loan, String docId);

  LocalDate map(String startDate);
}
