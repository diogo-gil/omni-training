/*-
 * #%L
 * Apps :: Training App with JWE integration App
 * %%
 * Copyright (C) 2016 - 2019 Digital Journey
 * %%
 * All rights reserved. This software is protected under several
 * Laws in various countries. All content, layout, design of this document are the
 * intellectual property of Digital Journey, Novabase Business Solutions S.A. 
 * and its licensors. The disclosure,copying, adaptation, citation, transcription, 
 * translation, modification, decompilation, reverse engineering, derivatives, 
 * integration, development and/or any other form of total or partial use of the 
 * content of this document and/or accessible through or via the contents, by any 
 * possible means without the respective authorization or licensing by the owner of 
 * the intellectual property rights is prohibited, the offenders being subject to civil 
 * and/or criminal prosecution and liability. The user or licensee of all or part of this 
 * document by any means may only use the document under the terms and conditions agreed
 * upon with the owner of the intellectual property rights, and for the purposes
 * justifying the granting of the license or authorization, without which the
 * unauthorized use may subject the offenders to civil or criminal prosecution
 * under applicable Laws.
 * #L%
 */
package com.celfocus.omnichannel.telco.apps.trainingappjwe.agent.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.metatype.annotations.Designate;

import com.celfocus.omnichannel.telco.apps.trainingappjwe.AppContext;
import com.celfocus.omnichannel.telco.apps.trainingappjwe.AppProperties;
import com.celfocus.omnichannel.telco.modules.trainingmicroservice.service.api.TrainingMicroserviceResource;
import com.celfocus.omnichannel.telco.modules.trainingmicroservice.service.api.dto.DishDTO;

import io.digitaljourney.platform.modules.mvc.api.agent.AbstractCoreAgent;

// @formatter:off
@Component(
	service = { Object.class, CoreAgentImpl.class },
	configurationPid = CoreAgentConfig.CPID,
	configurationPolicy = ConfigurationPolicy.REQUIRE,
	reference = {
		@Reference(
			name = AppProperties.REF_CONTEXT,
			service = AppContext.class,
			cardinality = ReferenceCardinality.MANDATORY)
	})
@Designate(ocd = CoreAgentConfig.class)
// @formatter:on
public class CoreAgentImpl extends AbstractCoreAgent<AppContext, CoreAgentConfig> {
	@Activate
	public void activate(ComponentContext ctx, CoreAgentConfig config) {
		prepare(ctx, config);
	}
	
	@Reference
	private volatile TrainingMicroserviceResource trainingMicroserviceResource;
	
	
	public List<DishDTO> getDishes() {
		
		Response response = trainingMicroserviceResource.listDishes();
		
		if (response.getStatus() != Status.OK.getStatusCode() ||
	    		(response.getStatus() == Status.OK.getStatusCode() && !response.hasEntity())) {

	    	return Collections.emptyList();
	    }
		
		ArrayList<DishDTO> dishesList = response.readEntity(new GenericType<ArrayList<DishDTO>>() { });
		
	    if (dishesList == null || dishesList.isEmpty()) {
	    	return Collections.emptyList();
       	}
	    
	    return dishesList;
	}
	
	public Optional<DishDTO> addDish(DishDTO body) {
		
		Response response = trainingMicroserviceResource.createDish(body);
		
		if (response.getStatus() != Status.OK.getStatusCode() ||
	    		(response.getStatus() == Status.OK.getStatusCode() && !response.hasEntity())) {

	    	return Optional.empty();
	    }
		
		DishDTO dish = response.readEntity(new GenericType<DishDTO>() { });
		
	    if (dish == null) {
	     	return Optional.empty();
       	}
	    
	    return Optional.of(dish);
	}	
}
