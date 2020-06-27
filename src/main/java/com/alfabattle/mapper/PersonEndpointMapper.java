package com.alfabattle.mapper;

import com.alfabattle.api.PersonResponse;
import com.alfabattle.entity.PersonEntity;
import org.mapstruct.Mapper;

/**
 * User: @AleksandrMIM
 * Date: 27.06.2020
 * Time: 17:33
 */
@Mapper(componentModel = "spring")
public interface PersonEndpointMapper {

  PersonResponse map(PersonEntity personEntity);
}
