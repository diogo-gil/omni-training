package com.celfocus.omnichannel.telco.modules.trainingmicroservice.service.ri;

import org.osgi.service.metatype.annotations.Icon;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "%name", description = "%description", localization = "OSGI-INF/l10n/trainingmicroservice", icon = @Icon(resource = "OSGI-INF/icon/resource.png", size = 32))
public @interface TrainingMicroserviceResourceConfig { 	
	public static final String CPID = "omni.telco.modules.trainingmicroservice.service.ri.trainingmicroservice";
}
