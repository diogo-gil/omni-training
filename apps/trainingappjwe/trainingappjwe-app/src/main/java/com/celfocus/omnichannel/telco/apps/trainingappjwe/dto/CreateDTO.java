package com.celfocus.omnichannel.telco.apps.trainingappjwe.dto;

import org.osgi.dto.DTO;

import io.swagger.annotations.ApiModel;
import net.karneim.pojobuilder.GeneratePojoBuilder;

@ApiModel
@GeneratePojoBuilder
public class CreateDTO extends DTO {
	public String customField;
}
