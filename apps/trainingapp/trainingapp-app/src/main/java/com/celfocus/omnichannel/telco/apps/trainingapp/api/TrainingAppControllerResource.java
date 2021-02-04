package com.celfocus.omnichannel.telco.apps.trainingapp.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.osgi.annotation.versioning.ProviderType;
import org.springframework.http.ResponseEntity;

import com.celfocus.omnichannel.telco.apps.trainingapp.AppProperties;
import com.celfocus.omnichannel.telco.apps.trainingapp.dto.Dish;

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
public interface TrainingAppControllerResource {

	@POST
	@Path("/dish")
	@ApiOperation(value = "Creates a process", notes = "Creates a new process instance", response = ResponseEntity.class)
	@RequiresPermissions(AppProperties.PERMISSION_CREATE)	
	@ApiResponses(value = {
			@ApiResponse(code = 200, response = ResponseEntity.class, message = "OK"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error")
	})
	public ResponseEntity<Dish> addDish(Dish dish);

	@GET
	@Path("/dishes")
	@ApiOperation(value = "Reads a process", notes = "Reads an existing process instance", response = ResponseEntity.class)
	@RequiresPermissions(AppProperties.PERMISSION_READ)	
	@ApiResponses(value = {
			@ApiResponse(code = 200, response = ResponseEntity.class, message = "OK"),
			@ApiResponse(code = 404, message = "Not Found"),
			@ApiResponse(code = 500, message = "Internal Server Error")
	})
	public ResponseEntity<List<Dish>> getAllDishes();
	
	
}
