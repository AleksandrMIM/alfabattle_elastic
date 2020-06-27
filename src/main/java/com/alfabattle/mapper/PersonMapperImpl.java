package com.alfabattle.mapper;

import com.alfabattle.entity.PersonEntity;
import com.alfabattle.model.Person;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.format.DateTimeFormatter;

/**
 * User: @AleksandrMIM
 * Date: 27.06.2020
 * Time: 2:32
 */
@Component
public class PersonMapperImpl implements PersonMapper {

  private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

  private final BigDecimal oneHundred = new BigDecimal("100");

  @Override
  public PersonEntity map(Person person) {
    PersonEntity personEntity = new PersonEntity();
    personEntity.setId(person.getId());
    personEntity.setDocId(person.getDocId());
    personEntity.setFio(person.getFio());
    personEntity.setGender(person.getGender());
    personEntity.setBirthday(dateTimeFormatter.format(person.getBirthday()));
    personEntity.setSalary(person.getSalary()
        .multiply(oneHundred)
        .setScale(0, RoundingMode.HALF_UP)
        .doubleValue()
    );

    return personEntity;
  }
}
