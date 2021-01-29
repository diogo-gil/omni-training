package com.celfocus.omnichannel.telco.modules.trainingmicroservice.data.ri.dishdao;

import javax.ws.rs.core.MediaType;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.Icon;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "%name", description = "%description", localization = "OSGI-INF/l10n/dishdao/dishdao", icon = @Icon(resource = "OSGI-INF/icon/ws.png", size = 32))
public @interface DishDAOConfig {

  public static final String CPID = "com.celfocus.omnichannel.telco.modules.trainingmicroservice.data.ri.dishdao";

  @AttributeDefinition(name = "%providerName.name", description = "%providerName.description")
  String providerName() default "Postman Echo";

  @AttributeDefinition(name = "%address.name", description = "%address.description")
  String address() default "https://postman-echo.com/time";

  @AttributeDefinition(name = "%contentType.name", description = "%contentType.description")
  String contentType() default MediaType.APPLICATION_JSON;

  @AttributeDefinition(name = "%acceptType.name", description = "%acceptType.description")
  String acceptType() default MediaType.APPLICATION_JSON;

  @AttributeDefinition(name = "%userName.name", description = "%userName.description")
  String userName() default "";

  @AttributeDefinition(name = "%password.name", type = AttributeType.PASSWORD, description = "%password.description")
  String password() default "";

  @AttributeDefinition(name = "%connectionTimeout.name", type = AttributeType.LONG, min = "0", description = "%connectionTimeout.description")
  long connectionTimeout() default 10000;

  @AttributeDefinition(name = "%receiveTimeout.name", type = AttributeType.LONG, min = "0", description = "%receiveTimeout.description")
  long receiveTimeout() default 180000;

  @AttributeDefinition(name = "%proxyEnabled.name", type = AttributeType.BOOLEAN, description = "%proxyEnabled.description")
  boolean proxyEnabled() default false;

  @AttributeDefinition(name = "%proxyHost.name", description = "%proxyHost.description")
  String proxyHost() default "localhost";

  @AttributeDefinition(name = "%proxyPort.name", description = "%proxyPort.description")
  int proxyPort() default 8888;

  @AttributeDefinition(name = "%jsonPathSuccessExpression.name", description = "%jsonPathSuccessExpression.description")
  String jsonPathSuccessExpression() default "";

  @AttributeDefinition(name = "%serializationFeatures.name", description = "%serializationFeatures.description")
  String[] serializationFeatures() default {};

  @AttributeDefinition(name = "%deserializationFeatures.name", description = "%deserializationFeatures.description")
  String[] deserializationFeatures() default {};
}
