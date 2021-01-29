package com.celfocus.omnichannel.telco.modules.trainingmicroservice.service.ri;

import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

import io.digitaljourney.platform.modules.async.api.PlatformAsyncManager;
import io.digitaljourney.platform.modules.cache.api.PlatformCacheManager;
import io.digitaljourney.platform.modules.commons.annotation.DocumentationResource;
import io.digitaljourney.platform.modules.invocation.api.PlatformInvocationManager;
import io.digitaljourney.platform.modules.security.api.PlatformSecurityManager;
import io.digitaljourney.platform.modules.ws.rs.api.context.AbstractRSEndpointContext;
import com.celfocus.omnichannel.telco.modules.trainingmicroservice.service.api.exception.TrainingMicroserviceException;

// @formatter:off
@Component(
	service = { Object.class, TrainingMicroserviceContext.class },
	reference = {
		@Reference(
			name = TrainingMicroserviceResourceProperties.REF_PLATFORM_SECURITY_MANAGER,
			service = PlatformSecurityManager.class,
			cardinality = ReferenceCardinality.MANDATORY),
        @Reference(
            name = TrainingMicroserviceResourceProperties.REF_PLATFORM_INVOCATION_MANAGER,
            service = PlatformInvocationManager.class,
            cardinality = ReferenceCardinality.MANDATORY),
		@Reference(
			name = TrainingMicroserviceResourceProperties.REF_ASYNC_MANAGER,
			service = PlatformAsyncManager.class,
			cardinality = ReferenceCardinality.MANDATORY),
		@Reference(
			name = TrainingMicroserviceResourceProperties.REF_CACHE_MANAGER,
			service = PlatformCacheManager.class,
			cardinality = ReferenceCardinality.MANDATORY)
	})
@DocumentationResource(TrainingMicroserviceResourceProperties.DOCS_ADDRESS)
// @formatter:on
public final class TrainingMicroserviceContext extends AbstractRSEndpointContext {
	@Activate
	public void activate(ComponentContext ctx) {
		prepare(ctx);
	}

	public TrainingMicroserviceException exception(String message) {
		return TrainingMicroserviceException.of(this, message);
	}

	public TrainingMicroserviceException exception(Throwable cause) {
		return TrainingMicroserviceException.of(this, cause);
	}
}
