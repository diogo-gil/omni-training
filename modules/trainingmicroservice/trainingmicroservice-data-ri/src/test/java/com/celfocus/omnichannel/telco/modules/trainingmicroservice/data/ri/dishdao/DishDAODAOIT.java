package com.celfocus.omnichannel.telco.modules.trainingmicroservice.data.ri.dishdao;

import static io.digitaljourney.platform.modules.paxexam.BundleOptions.mavenBundles;
import static io.digitaljourney.platform.modules.paxexam.BundleOptions.rsClient;
import static io.digitaljourney.platform.modules.paxexam.ConfigOptions.newConfiguration;
import static io.digitaljourney.platform.modules.paxexam.ConfigOptions.rsClientConfiguration;
import static org.ops4j.pax.exam.CoreOptions.composite;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.PaxExam;
import org.ops4j.pax.exam.spi.reactors.ExamReactorStrategy;
import org.ops4j.pax.exam.spi.reactors.PerClass;

import io.digitaljourney.platform.modules.paxexam.base.BaseTestSupport;
import com.celfocus.omnichannel.telco.modules.trainingmicroservice.data.ri.dishdao.DishDAOConfig;
import com.celfocus.omnichannel.telco.modules.trainingmicroservice.data.api.DishDAO;

@RunWith(PaxExam.class)
@ExamReactorStrategy(PerClass.class)
public class DishDAODAOIT extends BaseTestSupport {

  @SuppressWarnings("unused")
  @Inject
  private DishDAO dao;

  @Override
  protected Option bundles() {
    return composite(super.bundles(), rsClient(),
        mavenBundles("com.celfocus.omnichannel.telco.modules"),
        testBundle("com.celfocus.omnichannel.telco.modules", "trainingmicroservice-data-ri"));
  }

  @Override
  protected Option configurations() {
    return composite(super.configurations(),
        rsClientConfiguration("dishdao", newConfiguration(DishDAOConfig.CPID)));
  }

  @Test
  public void testBundle() {
    assertBundleActive("com.celfocus.omnichannel.telco.modules.trainingmicroservice-data-ri");
  }

}
