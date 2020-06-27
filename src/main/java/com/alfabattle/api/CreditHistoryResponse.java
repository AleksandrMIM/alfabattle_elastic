package com.alfabattle.api;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreditHistoryResponse{

	private int countLoan;
	private double sumAmountLoans;
	private List<LoanResponse> loans;
}