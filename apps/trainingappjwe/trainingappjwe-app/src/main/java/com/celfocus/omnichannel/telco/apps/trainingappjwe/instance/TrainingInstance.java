package com.celfocus.omnichannel.telco.apps.trainingappjwe.instance;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import io.digitaljourney.platform.plugins.modules.journeyworkflowengine.gateway.aspect.session.JourneyInstance;

public class TrainingInstance extends JourneyInstance implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<DishInstance> dishes = new ArrayList<>();

	public List<DishInstance> getDishes() {
		return dishes;
	}

	public void setDishes(List<DishInstance> dishes) {
		this.dishes = dishes;
	}

	public static class DishInstance {

		public String id;

		public String dishName;

		public String dishPrice;

		public boolean hasPromotion;

		public String rate;

		public boolean prepared = false;

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

		public String getRate() {
			return rate;
		}

		public void setRate(String rate) {
			this.rate = rate;
		}

		public boolean isPrepared() {
			return prepared;
		}

		public void setPrepared(boolean isPrepared) {
			this.prepared = isPrepared;
		}

	}

}
