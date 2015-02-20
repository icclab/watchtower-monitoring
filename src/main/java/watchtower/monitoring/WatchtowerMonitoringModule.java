/*
 * Copyright 2015 Zurich University of Applied Sciences
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
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