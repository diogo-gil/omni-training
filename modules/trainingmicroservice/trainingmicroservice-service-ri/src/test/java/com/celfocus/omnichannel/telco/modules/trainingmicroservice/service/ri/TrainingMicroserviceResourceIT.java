package com.celfocus.omnichannel.telco.modules.trainingmicroservice.service.ri;

import static io.digitaljourney.platform.modules.paxexam.BundleOptions.mavenBundles;
import static io.digitaljourney.platform.modules.paxexam.BundleOptions.rsProviderWithRSClient;
import static io.digitaljourney.platform.modules.paxexam.ConfigOptions.newConfiguration;
import static io.digitaljourney.platform.modules.paxexam.ConfigOptions.rsProviderWithRSClientConfiguration;
import static org.assertj.core.api.Assertions.assertThat;
import static org.ops4j.pax.exam.CoreOptions.composite;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.PaxExam;
import org.ops4j.pax.exam.spi.reactors.ExamReactorStrategy;
import org.ops4j.pax.exam.spi.reactors.PerClass;

import com.celfocus.omnichannel.telco.modules.trainingmicroservice.service.api.TrainingMicroserviceResource;

import io.digitaljourney.platform.modules.paxexam.base.BaseTestSupport;

@RunWith(PaxExam.class)
@ExamReactorStrategy(PerClass.class)
public class TrainingMicroserviceResourceIT extends BaseTestSupport {
	@Inject 
	private TrainingMicroserviceResource trainingmicroserviceResource;

	@Override
	protected Option bundles() {
		return composite(super.bundles(), rsProviderWithRSClient(),
				mavenBundles("com.celfocus.omnichannel.telco.modules", 
						"trainingmicroservice-entity", "trainingmicroservice-data-ri", "trainingmicroservice-service-api"),
				testBundle("com.celfocus.omnichannel.telco.modules", "trainingmicroservice-service-ri"));
	}

	@Override
	protected Option configurations() {
		return composite(super.configurations(),
                rsProviderWithRSClientConfiguration("trainingmicroservice", newConfiguration(TrainingMicroserviceResourceConfig.CPID)));
	}

	@Test
	public void testBundle() {
		assertBundleActive("com.celfocus.omnichannel.telco.modules.trainingmicroservice-service-ri");
	}

	@Test
	public void testDao() {
		assertThat(trainingmicroserviceResource).isNotNull();
	}

}
