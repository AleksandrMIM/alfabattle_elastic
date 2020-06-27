package com.alfabattle.mapper;

import com.alfabattle.entity.PersonEntity;
import com.alfabattle.model.Person;

/**
 * User: @AleksandrMIM
 * Date: 26.06.2020
 * Time: 11:45
 */
public interface PersonMapper {

  PersonEntity map(Person person);
}
