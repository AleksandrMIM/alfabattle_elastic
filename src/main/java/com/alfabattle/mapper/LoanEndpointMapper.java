package com.alfabattle.mapper;

import com.alfabattle.api.LoanResponse;
import com.alfabattle.entity.LoanEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * User: @AleksandrMIM
 * Date: 27.06.2020
 * Time: 17:33
 */
@Mapper(componentModel = "spring")
public interface LoanEndpointMapper {

  @Mapping(target = "document", source = "documentId")
  LoanResponse map(LoanEntity loanEntity);
}
