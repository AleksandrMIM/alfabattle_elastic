package com.alfabattle.mapper;

import com.alfabattle.api.PersonWithLoanResponse;
import com.alfabattle.entity.PersonEntity;

/**
 * User: @AleksandrMIM
 * Date: 27.06.2020
 * Time: 19:25
 */
public interface PersonWithLoanMapper {

  PersonWithLoanResponse map(PersonEntity personEntity);
}
