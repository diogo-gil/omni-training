package com.celfocus.omnichannel.telco.modules.trainingmicroservice.service.ri;

import io.digitaljourney.platform.modules.ws.rs.api.RSProperties;

public final class TrainingMicroserviceResourceProperties extends RSProperties {
	private TrainingMicroserviceResourceProperties() {}

	private static final String RESOURCE_NAME = "trainingmicroservice";

	private static final String RESOURCE_VERSION = "1";

	public static final String ADDRESS = "/" + RESOURCE_NAME + "/v" + RESOURCE_VERSION;

	public static final String DOCS_ADDRESS = CORE_RESOURCE_PATTERN + ADDRESS + DOCS_PATH;

	public static final String PERMISSION_ALL = RESOURCE_NAME + ACTION_ALL;
	public static final String PERMISSION_CREATE = RESOURCE_NAME + ACTION_CREATE;
	public static final String PERMISSION_READ = RESOURCE_NAME + ACTION_READ;
	public static final String PERMISSION_UPDATE = RESOURCE_NAME + ACTION_UPDATE;
	public static final String PERMISSION_DELETE = RESOURCE_NAME + ACTION_DELETE;
	public static final String PERMISSION_EXECUTE = RESOURCE_NAME + ACTION_EXECUTE;
}
