package com.alfabattle.service;

import com.alfabattle.entity.CreditHistoryEntity;
import com.alfabattle.entity.LoanEntity;

import java.util.List;
import java.util.Optional;

/**
 * User: @AleksandrMIM
 * Date: 27.06.2020
 * Time: 18:10
 */
public interface LoanService {

  void load();

  Optional<LoanEntity> getByDocId(String docId);

  List<LoanEntity> getClosed();

  CreditHistoryEntity getCreditHistory(String docId);

  List<LoanEntity> getByDocumentId(String docId);
}
