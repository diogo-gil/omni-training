package com.celfocus.omnichannel.telco.apps.trainingappjwe.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import com.celfocus.omnichannel.telco.apps.trainingappjwe.dto.Dish;
import com.celfocus.omnichannel.telco.apps.trainingappjwe.dto.TrainingDTO;
import com.celfocus.omnichannel.telco.apps.trainingappjwe.instance.TrainingInstance;
import com.celfocus.omnichannel.telco.modules.trainingmicroservice.service.api.dto.DishDTO;

@Mapper
public interface JourneyControllerMapper {
	public static final JourneyControllerMapper INSTANCE = Mappers.getMapper(JourneyControllerMapper.class);
	
	TrainingDTO toProcess(TrainingInstance instance);
	
	void mergeProcess(TrainingDTO process, @MappingTarget TrainingInstance instance);

	DishDTO toDishDTO(Dish dish);
	Dish toDish(DishDTO dishDTO);	
	
	List<Dish> toListDish(List<DishDTO> dish);
	
}
