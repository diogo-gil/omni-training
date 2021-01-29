package com.celfocus.omnichannel.telco.modules.trainingmicroservice.service.ri;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.metatype.annotations.Designate;

import com.celfocus.omnichannel.telco.modules.trainingmicroservice.data.api.DishDAO;
import com.celfocus.omnichannel.telco.modules.trainingmicroservice.service.api.TrainingMicroserviceResource;
import com.celfocus.omnichannel.telco.modules.trainingmicroservice.service.api.dto.DishDTO;

import io.digitaljourney.platform.modules.ws.rs.api.resource.AbstractResource;
import io.digitaljourney.platform.plugins.providers.rsprovider.annotations.CustomRsProvider;

// @formatter:off
@Component(
	configurationPid = TrainingMicroserviceResourceConfig.CPID,
	configurationPolicy = ConfigurationPolicy.REQUIRE,
	reference = {
		@Reference(
			name = TrainingMicroserviceResourceProperties.REF_CONTEXT,
			service = TrainingMicroserviceContext.class,
			cardinality = ReferenceCardinality.MANDATORY)
})
@Designate(ocd = TrainingMicroserviceResourceConfig.class)
@CustomRsProvider(TrainingMicroserviceResourceProperties.ADDRESS)
// @formatter:on
public class TrainingMicroserviceResourceImpl extends AbstractResource<TrainingMicroserviceContext, TrainingMicroserviceResourceConfig> implements TrainingMicroserviceResource {

	
	@Reference
	private volatile DishDAO dishDAO;
	
	/**
	 * Method called whenever the component is activated.
	 * 
	 * @param ctx    Component context
	 * @param config Component configuration
	 */
	@Activate
	public void activate(ComponentContext ctx, TrainingMicroserviceResourceConfig config) {
		prepare(ctx, config);
	}
	
	/**
	 * Method called whenever the component configuration is modified.
	 * 
	 * @param config Component configuration
	 */
	@Modified
	public void modified(TrainingMicroserviceResourceConfig config) {
		prepare(config);
	}
	
	
	@Override
	@RequiresAuthentication
	@RequiresPermissions(TrainingMicroserviceResourceProperties.PERMISSION_CREATE)
	public Response createDish(DishDTO dish) {
		ResponseBuilder responseBuilder = Response.status(Status.OK);
		return responseBuilder.entity(TrainingMicroserviceResourceMapper.INSTANCE.toDishDTO(dishDAO.createDish(TrainingMicroserviceResourceMapper.INSTANCE.toDish(dish)))).build();
	}

	@Override
	@RequiresAuthentication
	@RequiresPermissions(TrainingMicroserviceResourceProperties.PERMISSION_READ)
	public Response listDishes() {
		ResponseBuilder responseBuilder = Response.status(Status.OK);
		return responseBuilder.entity(TrainingMicroserviceResourceMapper.INSTANCE.toDishDTOList(dishDAO.getAllDishes())).build();
	}


}
