package com.alfabattle.mapper;

import com.alfabattle.api.PersonWithLoanResponse;
import com.alfabattle.entity.PersonEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * User: @AleksandrMIM
 * Date: 27.06.2020
 * Time: 19:33
 */
@Service
public class PersonWithLoanMapperImpl implements PersonWithLoanMapper {

  private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

  @Override
  public PersonWithLoanResponse map(PersonEntity personEntity) {
    if (personEntity == null) {
      return null;
    }

    PersonWithLoanResponse personWithLoanResponse = new PersonWithLoanResponse();

    personWithLoanResponse.setDocId(personEntity.getDocId());
    personWithLoanResponse.setBirthday(LocalDate.parse(personEntity.getBirthday(), dateTimeFormatter));
    personWithLoanResponse.setGender(personEntity.getGender());
    personWithLoanResponse.setSalary(personEntity.getSalary());
    personWithLoanResponse.setFio(personEntity.getFio());

    return personWithLoanResponse;
  }
}
