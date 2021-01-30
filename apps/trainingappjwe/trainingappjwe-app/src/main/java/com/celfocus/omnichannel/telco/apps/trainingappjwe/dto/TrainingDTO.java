package com.celfocus.omnichannel.telco.apps.trainingappjwe.dto;

import java.util.ArrayList;
import java.util.List;

import io.digitaljourney.platform.plugins.modules.journeyworkflowengine.gateway.aspect.dto.JourneyResponseDTO;

public class TrainingDTO extends JourneyResponseDTO{

	public List<Dish> dishes = new ArrayList<>();
}
