package com.celfocus.omnichannel.telco.modules.trainingmicroservice.data.ri;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import com.celfocus.omnichannel.telco.modules.trainingmicroservice.entity.Dish;

public class DishRepository {

	  private static DishRepository instance;

	  private final Map<String,Dish> dishes;

	  private final AtomicInteger idCounter;
	  
	  private DishRepository(){
		  dishes = getMockDishes();

		    Integer maxId = -1;
		    if(dishes != null){
		      maxId = dishes.entrySet().stream()
		          .filter(entry -> (entry.getValue() != null && entry.getValue().id != null))
		          .map(entry -> {
		            String id = entry.getValue().id;

		            Integer numericId = 0;
		            try {
		              numericId = Integer.parseInt(id);
		            } catch (NumberFormatException e) {

		            }
		            return numericId;
		          }).max((id1, id2) -> id1 > id2 ? 1 : (id1 == id2 ? 0 : -1)).orElse(0);
		    }

		    idCounter = new AtomicInteger(maxId);
		  }
	  
	  public static DishRepository getInstance(){
		  if(instance == null){
			  instance = new DishRepository();
		  }
		  return instance;
	  }
	  
	  private Map<String, Dish> getMockDishes() {  
		  
		  Map<String, Dish> dishes = new HashMap<>();
		  dishes.put("1", new Dish("1","Bifana","3",false));
		  dishes.put("2", new Dish("2","Prego","4",false));
		  dishes.put("3", new Dish("3", "Francesinha","7",true));	  

		  return dishes;
	  }
	  
	  public String incAndGetId(){
		    return idCounter.incrementAndGet() + "";
		  }

	public List<Dish> getAllDishes() {
		 return dishes.values().stream().collect(Collectors.toList());
	}

	public Dish createDish(Dish body) {
		
		String id = incAndGetId();
		body.id = id;
		
		dishes.put(id, body);
		
		return body;
	}	
}