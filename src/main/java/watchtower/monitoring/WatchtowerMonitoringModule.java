package watchtower.monitoring;

import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;

import watchtower.monitoring.configuration.WatchtowerMonitoringConfiguration;
import watchtower.monitoring.producer.KafkaProducer;
import watchtower.monitoring.producer.KafkaProducerFactory;
import io.dropwizard.setup.Environment;

public class WatchtowerMonitoringModule extends AbstractModule {
  private final WatchtowerMonitoringConfiguration configuration;
  private final Environment environment;
  
  public WatchtowerMonitoringModule(WatchtowerMonitoringConfiguration configuration, Environment environment) {
    this.configuration = configuration;
    this.environment = environment;
  }

  @Override
  protected void configure() {
    bind(WatchtowerMonitoringConfiguration.class).toInstance(configuration);
    bind(Environment.class).toInstance(environment);

    install(new FactoryModuleBuilder().implement(KafkaProducer.class, KafkaProducer.class)
        .build(KafkaProducerFactory.class));
  }
}