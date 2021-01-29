/*-
 * #%L
 * Apps :: Training App App
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
package com.celfocus.omnichannel.telco.apps.trainingapp.agent.repository;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.Icon;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

/**
 * Training App Repository Agent configuration.
 */
@ObjectClassDefinition(name = "%name", description = "%description", localization = "OSGI-INF/l10n/agent/repository", icon = @Icon(resource = "OSGI-INF/icon/agent.png", size = 32))
public @interface RepositoryAgentConfig {
	/** Component Persistent Identifier */
	static final String CPID = "omni.telco.apps.trainingapp.agent.repository";

	/**
	 * Gets the JCR provider target.
	 * 
	 * @return Provider target
	 */
	@AttributeDefinition(name = "%provider_target.name", description = "%provider_target.description", required  = true)
	String provider_target();
}
