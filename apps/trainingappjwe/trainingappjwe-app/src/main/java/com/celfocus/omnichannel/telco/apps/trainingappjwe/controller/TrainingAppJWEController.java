package com.celfocus.omnichannel.telco.apps.trainingappjwe.controller;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.celfocus.omnichannel.telco.apps.trainingappjwe.AppProperties;
import com.celfocus.omnichannel.telco.apps.trainingappjwe.api.JourneyControllerResource;
import com.celfocus.omnichannel.telco.apps.trainingappjwe.dto.Dish;
import com.celfocus.omnichannel.telco.apps.trainingappjwe.dto.TrainingDTO;
import com.celfocus.omnichannel.telco.apps.trainingappjwe.instance.TrainingInstance;
import com.celfocus.omnichannel.telco.apps.trainingappjwe.mapper.JourneyControllerMapper;
import com.celfocus.omnichannel.telco.modules.trainingmicroservice.service.api.dto.DishDTO;

import io.digitaljourney.platform.plugins.modules.journeyworkflowengine.gateway.aspect.annotation.JourneyMethod;
import io.digitaljourney.platform.plugins.modules.journeyworkflowengine.gateway.aspect.annotation.JourneyReference;
import io.digitaljourney.platform.plugins.modules.journeyworkflowengine.gateway.aspect.session.JourneySession;
import io.digitaljourney.platform.plugins.providers.rsprovider.annotations.CmsRsProvider;

@Controller
@Component
@CmsRsProvider(value = AppProperties.ADDRESS)
@RequestMapping("/" + AppProperties.ADDRESS)
public class TrainingAppJWEController extends AbstractAppController implements JourneyControllerResource {

	/**
	 * Create action mode creates a new empty instance and dish
	 */
	@JourneyMethod(value = "createDish")
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@Override
	public TrainingDTO createDishes(@RequestBody Dish dish) {
		TrainingInstance instance = JourneySession.getInstance(this);

		DishDTO newDish = JourneyControllerMapper.INSTANCE.toDishDTO(dish);
		newDish = getCoreAgent().addDish(newDish).get();
		
		TrainingDTO trainingDTO = new TrainingDTO();
		trainingDTO.dishes.add(JourneyControllerMapper.INSTANCE.toDish(newDish));
		
		JourneyControllerMapper.INSTANCE.mergeProcess(trainingDTO, instance);
		
		return JourneyControllerMapper.INSTANCE.toProcess(instance);
	}

	/**
	 * Retrieves existing dishes with a given ID
	 */
	@JourneyMethod(value = "getDishes")
	@RequestMapping(value = "/{instanceId}/dishes", method = RequestMethod.GET)
	public TrainingDTO getAllDishes(@JourneyReference Long instanceId) {
		TrainingInstance instance = JourneySession.getInstance(this);
		
		List<DishDTO> dishes = getCoreAgent().getDishes();
		List<Dish> dishesConverted = JourneyControllerMapper.INSTANCE.toListDish(dishes);
		
		TrainingDTO trainingDTO = new TrainingDTO();
		trainingDTO.dishes = dishesConverted;
		
		JourneyControllerMapper.INSTANCE.mergeProcess(trainingDTO, instance);
		
		return JourneyControllerMapper.INSTANCE.toProcess(instance);
	}

	/**
	 * Moves the journey instance to the final state (closed state) 
	 */
	@JourneyMethod(value = "Finish")
	@RequestMapping(value = "/{instanceId}/finish", method = RequestMethod.PUT)
	@Override
	public TrainingDTO finish(@JourneyReference Long instanceId) {
		TrainingInstance instance = JourneySession.getInstance(this);
		return JourneyControllerMapper.INSTANCE.toProcess(instance);
	}


}
