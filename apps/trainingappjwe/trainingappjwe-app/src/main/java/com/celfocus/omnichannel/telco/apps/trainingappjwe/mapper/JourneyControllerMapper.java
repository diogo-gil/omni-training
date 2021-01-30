package com.celfocus.omnichannel.telco.apps.trainingappjwe.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.celfocus.omnichannel.telco.apps.trainingappjwe.dto.CustomJourneyDTO;
import com.celfocus.omnichannel.telco.apps.trainingappjwe.instance.CustomJourneyInstance;

@Mapper
public interface JourneyControllerMapper {
	public static final JourneyControllerMapper INSTANCE = Mappers.getMapper(JourneyControllerMapper.class);

	CustomJourneyDTO toProcess(CustomJourneyInstance instance);
}
