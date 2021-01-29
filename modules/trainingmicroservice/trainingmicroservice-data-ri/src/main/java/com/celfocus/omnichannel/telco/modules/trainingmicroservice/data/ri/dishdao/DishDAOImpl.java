package com.celfocus.omnichannel.telco.modules.trainingmicroservice.data.ri.dishdao;

import java.util.List;

import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.metatype.annotations.Designate;

import io.digitaljourney.platform.modules.ws.rs.api.RSProperties;
import io.digitaljourney.platform.modules.ws.rs.api.dao.AbstractRSDAO;

import com.celfocus.omnichannel.telco.modules.trainingmicroservice.data.ri.DishRepository;
import com.celfocus.omnichannel.telco.modules.trainingmicroservice.data.ri.WSContext;
import com.celfocus.omnichannel.telco.modules.trainingmicroservice.entity.Dish;
import com.celfocus.omnichannel.telco.modules.trainingmicroservice.data.api.DishDAO;

// @formatter:off
@Component(
  configurationPid = DishDAOConfig.CPID,
  configurationPolicy = ConfigurationPolicy.REQUIRE,
  reference = {
    @Reference(
      name = RSProperties.REF_CONTEXT,
      service = WSContext.class, 
      cardinality = ReferenceCardinality.MANDATORY) })
@Designate(ocd = DishDAOConfig.class)
// @formatter:on
public final class DishDAOImpl extends AbstractRSDAO<DishDAOConfig> implements DishDAO {

    @Activate
    public void activate(ComponentContext ctx, DishDAOConfig config) {
      prepare(ctx, config);
    }

    @Modified
    public void modified(DishDAOConfig config) {
      prepare(config);
    }

	@Override
	public List<Dish> getAllDishes() {
		DishRepository instance = DishRepository.getInstance();
		return instance.getAllDishes();
	}

	@Override
	public Dish createDish(Dish dish) {
		DishRepository instance = DishRepository.getInstance();
		return instance.createDish(dish);
	}

}
