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
package com.celfocus.omnichannel.telco.apps.trainingapp;

import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.metatype.annotations.Designate;

import io.digitaljourney.platform.modules.async.api.PlatformAsyncManager;
import io.digitaljourney.platform.modules.cache.api.PlatformCacheManager;
import io.digitaljourney.platform.modules.commons.annotation.DocumentationResource;
import io.digitaljourney.platform.modules.invocation.api.PlatformInvocationManager;
import io.digitaljourney.platform.modules.mvc.api.context.AbstractMVCContext;
import io.digitaljourney.platform.modules.security.api.PlatformSecurityManager;
import io.digitaljourney.platform.modules.security.api.SystemSecurityManager;
import com.celfocus.omnichannel.telco.apps.trainingapp.agent.core.CoreAgentConfig;
import com.celfocus.omnichannel.telco.apps.trainingapp.exception.TrainingAppException;

// @formatter:off
/**
 * Training App App implementation of an {@link AbstractMVCContext MVC Context}.
 * 
 */
@Component(
	service = { Object.class, AppContext.class },
	reference = {
		@Reference(
			name = AppProperties.REF_PLATFORM_SECURITY_MANAGER,
			service = PlatformSecurityManager.class,
            policy = ReferencePolicy.DYNAMIC,
            cardinality = ReferenceCardinality.OPTIONAL),
        @Reference(
            name = AppProperties.REF_SYSTEM_SECURITY_MANAGER,
            service = SystemSecurityManager.class,			
			cardinality = ReferenceCardinality.MANDATORY),
		@Reference(
			name = AppProperties.REF_PLATFORM_INVOCATION_MANAGER,
			service = PlatformInvocationManager.class,
			cardinality = ReferenceCardinality.MANDATORY),
		@Reference(
			name = AppProperties.REF_ASYNC_MANAGER,
			service = PlatformAsyncManager.class,
			cardinality = ReferenceCardinality.MANDATORY),
		@Reference(
			name = AppProperties.REF_CACHE_MANAGER,
			service = PlatformCacheManager.class,
			cardinality = ReferenceCardinality.MANDATORY)
	})
@DocumentationResource(AppProperties.DOCS_ADDRESS)
@Designate(ocd = CoreAgentConfig.class)
// @formatter:on
public class AppContext extends AbstractMVCContext {

	/**
	 * Method called whenever the component is activated.
	 *
	 * @param ctx Component context
	 */
	@Activate
	public void activate(ComponentContext ctx) {
		prepare(ctx);
	}
	
	/**
	 * Creates a new Training App Exception (500 - Internal Server Error) with the
	 * given error message.
	 *
	 * @param message Error message
	 * @return Created exception
	 */
	public TrainingAppException exception(String message) {
		return TrainingAppException.of(this, message);
	}

	/**
	 * Creates a new Training App Exception (500 - Internal Server Error) with the
	 * given error cause.
	 *
	 * @param cause Error cause
	 * @return Created exception
	 */
	public TrainingAppException exception(Throwable cause) {
		return TrainingAppException.of(this, cause);
	}
}
