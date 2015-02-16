package watchtower.monitoring;

import com.google.inject.AbstractModule;

import watchtower.monitoring.configuration.WatchtowerMonitoringConfiguration;
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
  }
}
