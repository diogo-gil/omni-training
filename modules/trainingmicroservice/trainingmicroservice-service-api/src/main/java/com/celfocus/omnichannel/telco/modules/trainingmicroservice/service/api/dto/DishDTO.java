package com.celfocus.omnichannel.telco.modules.trainingmicroservice.service.api.dto;

import java.io.Serializable;

import org.osgi.dto.DTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import net.karneim.pojobuilder.GeneratePojoBuilder;

@ApiModel(description = "Dish DTO")
@GeneratePojoBuilder
public class DishDTO extends DTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2980876843219081476L;

	@ApiModelProperty(value = "the dish id")
	public String id;
	
	@ApiModelProperty(value = "the dish name")
	public String dishName;
	
	@ApiModelProperty(value = "the dish price")
	public String dishPrice;
	
	@ApiModelProperty(value = "the dish is in promotion")
	public boolean hasPromotion;

	public DishDTO() {
		super();
	}

	public DishDTO(String id, String dishName, String dishPrice, boolean hasPromotion) {
		super();
		this.id = id;
		this.dishName = dishName;
		this.dishPrice = dishPrice;
		this.hasPromotion = hasPromotion;
	}

}
