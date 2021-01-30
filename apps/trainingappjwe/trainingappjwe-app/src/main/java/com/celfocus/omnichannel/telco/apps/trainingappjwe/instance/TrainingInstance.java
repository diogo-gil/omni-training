package com.celfocus.omnichannel.telco.apps.trainingappjwe.instance;

import java.io.Serializable;
import java.util.List;

import com.celfocus.omnichannel.telco.apps.trainingappjwe.dto.Dish;

import io.digitaljourney.platform.plugins.modules.journeyworkflowengine.gateway.aspect.session.JourneyInstance;

public class TrainingInstance extends JourneyInstance implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private List<Dish> dishes;


	public List<Dish> getDishes() {
		return dishes;
	}


	public void setDishes(List<Dish> dishes) {
		this.dishes = dishes;
	}
	
	
}
