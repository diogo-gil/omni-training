package com.celfocus.omnichannel.telco.modules.trainingmicroservice.service.api;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.osgi.annotation.versioning.ProviderType;

import com.celfocus.omnichannel.telco.modules.trainingmicroservice.service.api.dto.DishDTO;

import io.digitaljourney.platform.modules.commons.type.HttpStatusCode;
import io.digitaljourney.platform.modules.ws.rs.api.RSProperties;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiKeyAuthDefinition;
import io.swagger.annotations.ApiKeyAuthDefinition.ApiKeyLocation;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import io.swagger.annotations.BasicAuthDefinition;
import io.swagger.annotations.SecurityDefinition;
import io.swagger.annotations.SwaggerDefinition;

@ProviderType
@Path("")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

@SwaggerDefinition(securityDefinition = @SecurityDefinition(basicAuthDefinitions = {
        @BasicAuthDefinition(key = RSProperties.SWAGGER_BASIC_AUTH) }, apiKeyAuthDefinitions = {
                @ApiKeyAuthDefinition(key = RSProperties.SWAGGER_BEARER_AUTH, name = RSProperties.HTTP_HEADER_API_KEY, in = ApiKeyLocation.HEADER) }), schemes = {
                        SwaggerDefinition.Scheme.HTTP, SwaggerDefinition.Scheme.HTTPS,
                        SwaggerDefinition.Scheme.DEFAULT })
@Api(value = "Training Microservice", authorizations = { @Authorization(value = RSProperties.SWAGGER_BASIC_AUTH),
        @Authorization(value = RSProperties.SWAGGER_BEARER_AUTH) })
@ApiResponses(value = {
        @ApiResponse(code = HttpStatusCode.UNAUTHORIZED_CODE, message = RSProperties.SWAGGER_UNAUTHORIZED_MESSAGE),
        @ApiResponse(code = HttpStatusCode.FORBIDDEN_CODE, message = RSProperties.SWAGGER_FORBIDDEN_MESSAGE) })
public interface TrainingMicroserviceResource {

	@POST
	@Path("/dish")
	@ApiOperation(value = "create a new dish")
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Created", response = DishDTO.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)
	})
	Response createDish(@Valid @NotNull DishDTO dish);
	
	@GET
	@Path("/dish")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Ok", response = DishDTO.class, responseContainer = "List"),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 500, message = "Internal Server Error", response = Error.class)
	})
	Response listDishes();

}
