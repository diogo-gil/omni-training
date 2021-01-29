package com.celfocus.omnichannel.telco.modules.trainingmicroservice.service.ri;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.celfocus.omnichannel.telco.modules.trainingmicroservice.entity.Dish;
import com.celfocus.omnichannel.telco.modules.trainingmicroservice.service.api.dto.DishDTO;

@Mapper
public interface TrainingMicroserviceResourceMapper {
	public static final TrainingMicroserviceResourceMapper INSTANCE = Mappers.getMapper(TrainingMicroserviceResourceMapper.class);
	
	
	List<DishDTO> toDishDTOList(List<Dish> dishList);
	List<Dish> toDishList(List<DishDTO> dishList);
	
	@Mapping(source = "id", target = "id")
	@Mapping(source = "dishName", target = "dishName")
	@Mapping(source = "dishPrice", target = "dishPrice")
	@Mapping(source = "hasPromotion", target = "hasPromotion")
	DishDTO toDishDTO(Dish dish);
	
	Dish toDish(DishDTO dish);
	
}
