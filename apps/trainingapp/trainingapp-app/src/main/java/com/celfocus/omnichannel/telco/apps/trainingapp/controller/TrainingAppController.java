/*-
 * #%L
 * Apps :: Training App App
 * %%
 * Copyright (C) 2016 - 2020 Digital Journey
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
package com.celfocus.omnichannel.telco.apps.trainingapp.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.osgi.service.component.annotations.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import com.celfocus.omnichannel.telco.apps.trainingapp.AppProperties;

import io.digitaljourney.platform.modules.commons.type.HttpStatusCode;
import io.digitaljourney.platform.modules.ws.rs.api.RSProperties;
import io.digitaljourney.platform.plugins.providers.rsprovider.annotations.CmsRsProvider;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiKeyAuthDefinition;
import io.swagger.annotations.ApiKeyAuthDefinition.ApiKeyLocation;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import io.swagger.annotations.BasicAuthDefinition;
import io.swagger.annotations.ExternalDocs;
import io.swagger.annotations.Info;
import io.swagger.annotations.License;
import io.swagger.annotations.SecurityDefinition;
import io.swagger.annotations.SwaggerDefinition;

//@formatter:off
/**
 * Base Training App Resource, this is only used for documentation purposes.
 * *
 */
@Component(
	service = {TrainingAppController.class}
)
@CmsRsProvider(value=AppProperties.ADDRESS)
@RequestMapping(AppProperties.ADDRESS)
@Path(AppProperties.ADDRESS)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@SwaggerDefinition(
	securityDefinition = @SecurityDefinition(
		basicAuthDefinitions = {
			@BasicAuthDefinition(key = RSProperties.SWAGGER_BASIC_AUTH),
		},
		apiKeyAuthDefinitions = {
			@ApiKeyAuthDefinition(
				key = RSProperties.SWAGGER_BEARER_AUTH,
				name = RSProperties.HTTP_HEADER_API_KEY,
				in = ApiKeyLocation.HEADER)
			}
	),
	schemes = {
		SwaggerDefinition.Scheme.HTTP,
		SwaggerDefinition.Scheme.HTTPS,
		SwaggerDefinition.Scheme.DEFAULT
	},
	info = @Info(
		title = "Training App API",
		description = "The Training App API.",
		version = AppProperties.CURRENT_VERSION,
		license = @License(name = "Digital Journey License", url = "http://www.digitaljourney.io/license")
	),
	basePath = "bin/mvc.do/"+AppProperties.ADDRESS
)
@Api(
	value = "Training App API",
	authorizations = {
		@Authorization(value = RSProperties.SWAGGER_BASIC_AUTH),
		@Authorization(value = RSProperties.SWAGGER_BEARER_AUTH)
	}
)
@ApiResponses(
	value = {
		@ApiResponse(code = HttpStatusCode.UNAUTHORIZED_CODE, message = RSProperties.SWAGGER_UNAUTHORIZED_MESSAGE),
		@ApiResponse(code = HttpStatusCode.FORBIDDEN_CODE, message = RSProperties.SWAGGER_FORBIDDEN_MESSAGE)
	}
)
//@formatter:on
public class TrainingAppController extends AbstractAppController {
	// nothing here we just fake some endpoints
	/** Base CXF path */
	public static final String BASE_CXF_PATH = "cms";

	/**
	 * Fake endpoint to document resources
	 */
	@GET
	@Path("/")
	@ApiOperation(value = "Endpoint description", notes = "This is a mock endpoint")
	@ExternalDocs(url = BASE_CXF_PATH + AppProperties.ADDRESS
			+ "/api-docs?url=../swagger.json", value = "Endpoint description")
	public void getOauth() {
		// no op
	}
}