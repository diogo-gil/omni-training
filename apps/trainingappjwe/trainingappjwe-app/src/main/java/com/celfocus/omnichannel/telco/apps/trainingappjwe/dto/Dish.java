package com.celfocus.omnichannel.telco.apps.trainingappjwe.dto;

public class Dish {
	
	public String id;
	
	public String dishName;
	
	public String dishPrice;
	
	public boolean hasPromotion;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public String getDishPrice() {
		return dishPrice;
	}

	public void setDishPrice(String dishPrice) {
		this.dishPrice = dishPrice;
	}

	public boolean isHasPromotion() {
		return hasPromotion;
	}

	public void setHasPromotion(boolean hasPromotion) {
		this.hasPromotion = hasPromotion;
	}
	
	

}