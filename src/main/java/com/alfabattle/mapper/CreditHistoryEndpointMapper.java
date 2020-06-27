package com.alfabattle.mapper;

import com.alfabattle.api.CreditHistoryResponse;
import com.alfabattle.entity.CreditHistoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;

/**
 * User: @AleksandrMIM
 * Date: 27.06.2020
 * Time: 18:45
 */
@Mapper(componentModel = "spring")
@MapperConfig(uses = LoanEndpointMapper.class)
public interface CreditHistoryEndpointMapper {

  CreditHistoryResponse map(CreditHistoryEntity creditHistoryEntity);
}
