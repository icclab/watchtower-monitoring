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

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import watchtower.monitoring.configuration.WatchtowerMonitoringConfiguration;
import watchtower.monitoring.resources.EventsResource;
import watchtower.monitoring.resources.MonascaResource;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class WatchtowerMonitoringApplication extends Application<WatchtowerMonitoringConfiguration> {

  public static void main(String[] args) throws Exception {
    new WatchtowerMonitoringApplication().run(args);
  }

  @Override
  public void initialize(Bootstrap<WatchtowerMonitoringConfiguration> bootstrap) {

  }

  @Override
  public void run(WatchtowerMonitoringConfiguration configuration, Environment environment)
      throws Exception {
    Injector injector =
        Guice.createInjector(new WatchtowerMonitoringModule(configuration, environment));

    environment.jersey().register(injector.getInstance(EventsResource.class));
    environment.jersey().register(injector.getInstance(MonascaResource.class));
  }

  @Override
  public String getName() {
    return "watchtower-monitoring";
  }
}