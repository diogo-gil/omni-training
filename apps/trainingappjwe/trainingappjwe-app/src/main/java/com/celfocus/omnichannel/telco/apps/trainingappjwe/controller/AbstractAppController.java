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
package com.celfocus.omnichannel.telco.apps.trainingappjwe.controller;

import org.eclipse.gemini.blueprint.extensions.annotation.ServiceReference;

import com.celfocus.omnichannel.telco.apps.trainingappjwe.AppContext;
import com.celfocus.omnichannel.telco.apps.trainingappjwe.AppProperties;
import com.celfocus.omnichannel.telco.apps.trainingappjwe.agent.core.CoreAgentImpl;
import com.celfocus.omnichannel.telco.apps.trainingappjwe.agent.repository.RepositoryAgentImpl;
import com.celfocus.omnichannel.telco.apps.trainingappjwe.instance.TrainingInstance;

import io.digitaljourney.platform.plugins.modules.journeyworkflowengine.api.JourneyWorkflowEngineResource;
import io.digitaljourney.platform.plugins.modules.journeyworkflowengine.gateway.aspect.JourneyProcess;
import io.digitaljourney.platform.plugins.modules.journeyworkflowengine.gateway.aspect.controller.AbstractJourneyController;

public abstract class AbstractAppController extends AbstractJourneyController<AppContext> implements JourneyProcess<TrainingInstance> {

	@ServiceReference
	private AppContext ctx;

	@ServiceReference
	private RepositoryAgentImpl repositoryAgent;

	@ServiceReference
	private CoreAgentImpl coreAgent;

	@Override
	protected AppContext getCtx() {
		return this.ctx;
	}

	@Override
	public JourneyWorkflowEngineResource getJourneyEngine() {
		return journeyEngine();
	}

	protected RepositoryAgentImpl getRepositoryAgent() {
		return this.repositoryAgent;
	}

	protected CoreAgentImpl getCoreAgent() {
		return this.coreAgent;
	}
	
	@Override
	public String journeyName() {
		return AppProperties.JOURNEY_NAME;
	}

	@Override
	public int majorVersion() {
		return AppProperties.JOURNEY_VERSION;
	}

	@Override
	public Class<TrainingInstance> getInstanceClass() {
		return TrainingInstance.class;
	}	
}
