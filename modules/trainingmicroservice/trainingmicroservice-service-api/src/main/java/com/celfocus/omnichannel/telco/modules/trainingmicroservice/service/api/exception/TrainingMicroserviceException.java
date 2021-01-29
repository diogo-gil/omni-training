package com.celfocus.omnichannel.telco.modules.trainingmicroservice.service.api.exception;

import io.digitaljourney.platform.modules.commons.context.Context;
import io.digitaljourney.platform.modules.commons.exception.PlatformCode;
import io.digitaljourney.platform.modules.ws.rs.api.exception.RSException;
import com.celfocus.omnichannel.telco.modules.trainingmicroservice.service.api.TrainingMicroserviceProperties;

public class TrainingMicroserviceException extends RSException {
	private static final long serialVersionUID = -8645577031119256555L;

	protected TrainingMicroserviceException(PlatformCode statusCode, String errorCode, Context ctx, Object... args) {
		super(statusCode, errorCode, ctx, args);
	}

	protected TrainingMicroserviceException(Context ctx, Object... args) {
		this(PlatformCode.INTERNAL_SERVER_ERROR, TrainingMicroserviceProperties.TRAININGMICROSERVICE000, ctx, args);
	}

	protected TrainingMicroserviceException(String errorCode, Context ctx, Object... args) {
		this(PlatformCode.BUSINESS_ERROR, errorCode, ctx, args);
	}

	public static TrainingMicroserviceException of(Context ctx, String message) {
		return new TrainingMicroserviceException(ctx, message);
	}

	public static TrainingMicroserviceException of(Context ctx, Throwable cause) {
		return new TrainingMicroserviceException(ctx, cause);
	}
}
