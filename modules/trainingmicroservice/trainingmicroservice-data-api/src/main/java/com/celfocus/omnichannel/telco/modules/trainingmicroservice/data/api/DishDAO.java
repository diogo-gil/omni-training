package com.celfocus.omnichannel.telco.modules.trainingmicroservice.data.api;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

import com.celfocus.omnichannel.telco.modules.trainingmicroservice.entity.Dish;

@ProviderType
public interface DishDAO {
	
	List<Dish> getAllDishes();
	
	Dish createDish(Dish dish);

}
