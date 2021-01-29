package com.celfocus.omnichannel.telco.modules.trainingmicroservice.data.ri.dishdao;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DishDAOMapper {

  public static final DishDAOMapper INSTANCE = Mappers.getMapper(DishDAOMapper.class);

}
