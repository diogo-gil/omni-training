package com.celfocus.omnichannel.telco.apps.trainingapp.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.celfocus.omnichannel.telco.apps.trainingapp.dto.Dish;
import com.celfocus.omnichannel.telco.modules.trainingmicroservice.service.api.dto.DishDTO;

@Mapper
public interface TrainingAppMapper {

	public static final TrainingAppMapper INSTANCE = Mappers.getMapper(TrainingAppMapper.class);
	
	
	DishDTO toDishDTO(Dish dish);
	
	Dish toDish(DishDTO dishDTO);
	
	List<Dish> toListDish(List<DishDTO> dishDTO);
	
}
