package com.celfocus.omnichannel.telco.apps.trainingappjwe.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.osgi.annotation.versioning.ProviderType;

import com.celfocus.omnichannel.telco.apps.trainingappjwe.AppProperties;
import com.celfocus.omnichannel.telco.apps.trainingappjwe.dto.Dish;
import com.celfocus.omnichannel.telco.apps.trainingappjwe.dto.TrainingDTO;

import io.digitaljourney.platform.modules.commons.type.HttpStatusCode;
import io.digitaljourney.platform.modules.ws.rs.api.RSProperties;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiKeyAuthDefinition;
import io.swagger.annotations.ApiKeyAuthDefinition.ApiKeyLocation;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import io.swagger.annotations.BasicAuthDefinition;
import io.swagger.annotations.SecurityDefinition;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@ProviderType
@Path(AppProperties.ADDRESS)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@SwaggerDefinition(
		securityDefinition = @SecurityDefinition(
				basicAuthDefinitions = {
						@BasicAuthDefinition(key = RSProperties.SWAGGER_BASIC_AUTH)
				},
				apiKeyAuthDefinitions = {
						@ApiKeyAuthDefinition(key = RSProperties.SWAGGER_BEARER_AUTH, name = RSProperties.HTTP_HEADER_API_KEY, in = ApiKeyLocation.HEADER)
				}),
		schemes = {
				SwaggerDefinition.Scheme.HTTP,
				SwaggerDefinition.Scheme.HTTPS,
				SwaggerDefinition.Scheme.DEFAULT
		},
		tags = { @Tag(name = "Journey", description = "Journey API") })
@Api(
		value = "Custom Journey",
		authorizations = {
				@Authorization(value = RSProperties.SWAGGER_BASIC_AUTH),
				@Authorization(value = RSProperties.SWAGGER_BEARER_AUTH)
		},
		tags = { "Journey" })
@ApiResponses(value = {
		@ApiResponse(code = HttpStatusCode.UNAUTHORIZED_CODE, message = RSProperties.SWAGGER_UNAUTHORIZED_MESSAGE),
		@ApiResponse(code = HttpStatusCode.FORBIDDEN_CODE, message = RSProperties.SWAGGER_FORBIDDEN_MESSAGE) })
public interface JourneyControllerResource {

	@POST
	@Path("/createDish")
	@ApiOperation(value = "Creates a process", notes = "Creates a new process instance", response = TrainingDTO.class)
	@RequiresPermissions(AppProperties.PERMISSION_CREATE)	
	@ApiResponses(value = {
			@ApiResponse(code = 200, response = TrainingDTO.class, message = "OK"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error")
	})
	public TrainingDTO createDishes(Dish dish);

	@GET
	@Path("/{instanceId}/dishes")
	@ApiOperation(value = "Get dishes", notes = "Get Dishes", response = TrainingDTO.class)
	@RequiresPermissions(AppProperties.PERMISSION_READ)	
	@ApiResponses(value = {
			@ApiResponse(code = 200, response = TrainingDTO.class, message = "OK"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error")
	})
	public TrainingDTO getAllDishes(
			@ApiParam(value = "The unique identifier of the process instance", required = true, example = "1") @PathParam("instanceId") Long instanceId);
	
	@PUT
	@Path("/{instanceId}/prepare/{dishId}")
	@ApiOperation(value = "Prepare Dish", notes = "Prepare Dish", response = TrainingDTO.class)
	@RequiresPermissions(AppProperties.PERMISSION_READ)	
	@ApiResponses(value = {
			@ApiResponse(code = 200, response = TrainingDTO.class, message = "OK"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error")
	})
	public TrainingDTO prepareDish(
			@ApiParam(value = "The unique identifier of the process instance", required = true, example = "1") @PathParam("instanceId") Long instanceId,
			@ApiParam(value = "The unique identifier of the dish", required = true, example = "1") @PathParam("dishId") Long dishId);	
	
	@PUT
	@Path("/{instanceId}/rate/{rateValue}")
	@ApiOperation(value = "Rate Dish", notes = "Rate Dish", response = TrainingDTO.class)
	@RequiresPermissions(AppProperties.PERMISSION_READ)	
	@ApiResponses(value = {
			@ApiResponse(code = 200, response = TrainingDTO.class, message = "OK"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error")
	})
	public TrainingDTO rateDish(
			@ApiParam(value = "The unique identifier of the process instance", required = true, example = "1") @PathParam("instanceId") Long instanceId,
			@ApiParam(value = "The rate of dish", required = true, example = "1") @PathParam("rateValue") String rate);		
	
	@PUT
	@Path("/{instanceId}/finish")
	@ApiOperation(value = "Finish process", notes = "Finishes the process", response = TrainingDTO.class)
	@RequiresPermissions(AppProperties.PERMISSION_UPDATE)	
	@ApiResponses(value = {
			@ApiResponse(code = 200, response = TrainingDTO.class, message = "OK"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error")
	})
	public TrainingDTO finish(
			@ApiParam(value = "The unique identifier of the process instance", required = true, example = "1") @PathParam("instanceId") Long instanceId);
}
