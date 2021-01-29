package com.celfocus.omnichannel.telco.modules.trainingmicroservice.entity;

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

	public Dish() {
		super();
	}

	public Dish(String id, String dishName, String dishPrice, boolean hasPromotion) {
		super();
		this.id = id;
		this.dishName = dishName;
		this.dishPrice = dishPrice;
		this.hasPromotion = hasPromotion;
	}

	
}
