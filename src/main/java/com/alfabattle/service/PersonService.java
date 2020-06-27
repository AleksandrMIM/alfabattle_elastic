package com.alfabattle.service;

import com.alfabattle.entity.PersonEntity;

import java.util.List;
import java.util.Optional;

/**
 * User: @AleksandrMIM
 * Date: 27.06.2020
 * Time: 16:51
 */
public interface PersonService {

  void load();

  Optional<PersonEntity> getByDocId(String docId);

  List<PersonEntity> getPersonSortById();
}
