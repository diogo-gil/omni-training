/*-
 * #%L
 * Archetype :: APP Vault
 * %%
 * Copyright (C) 2016 - 2018 Digital Journey
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

import org.eclipse.gemini.blueprint.extensions.annotation.ServiceReference;

import io.digitaljourney.platform.modules.mvc.api.controller.AbstractController;
import com.celfocus.omnichannel.telco.apps.trainingapp.AppContext;
import com.celfocus.omnichannel.telco.apps.trainingapp.agent.core.CoreAgentImpl;
import com.celfocus.omnichannel.telco.apps.trainingapp.agent.repository.RepositoryAgentImpl;

/**
 * Abstract application controller which extends an {@link AbstractController
 * Abstract Controller}.
 */
public abstract class AbstractAppController extends AbstractController<AppContext> {
  
	@ServiceReference
	private AppContext ctx;
  
	@ServiceReference
	private RepositoryAgentImpl repositoryAgent;
	
	@ServiceReference
	private CoreAgentImpl coreAgent;

	/**
	 * Gets the application context.
	 *
	 * @return Context
	 */
	@Override
	protected AppContext getCtx() {
		return this.ctx;
	}
	
	/**
	 * Gets the repository agent implementation.
	 *
	 * @return Repository agent implementation
	 */
	protected RepositoryAgentImpl getRepositoryAgent() {
		return this.repositoryAgent;
	}
	
	/**
	 * Gets the core agent implementation.
	 *
	 * @return Core agent implementation
	 */
	protected CoreAgentImpl getCoreAgent() {
		return this.coreAgent;
	}
}
