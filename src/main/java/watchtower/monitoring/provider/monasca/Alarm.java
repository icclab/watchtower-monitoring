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
package watchtower.monitoring.provider.monasca;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

public class Alarm {
  private String id;
  private String definitionId;
  private String name;
  private String description;
  private long timestamp;
  private String message;
  private AlarmState state;
  private AlarmState oldState;
  private String tenantId;
  List<Metric> metrics;

  public Alarm() {
    // Empty constructor
  }

  @JsonCreator
  public Alarm(@JsonProperty("alarm_id") String id,
      @JsonProperty("alarm_definition_id") String definitionId,
      @JsonProperty("alarm_name") String name,
      @JsonProperty("alarm_description") String description,
      @JsonProperty("alarm_timestamp") long timestamp, @JsonProperty("message") String message,
      @JsonProperty("state") AlarmState state, @JsonProperty("old_state") AlarmState oldState,
      @JsonProperty("tenant_id") String tenantId, @JsonProperty("metrics") List<Metric> metrics) {
    this.id = id;
    this.definitionId = definitionId;
    this.name = name;
    this.description = description;
    this.timestamp = timestamp;
    this.message = message;
    this.state = state;
    this.oldState = oldState;
    this.tenantId = tenantId;
    this.metrics = metrics;
  }

  @JsonProperty("alarm_id")
  public String getId() {
    return id;
  }

  @JsonProperty("alarm_id")
  public void setId(String id) {
    this.id = id;
  }

  @JsonProperty("alarm_definition_id")
  public String getDefinitionId() {
    return definitionId;
  }

  @JsonProperty("alarm_definition_id")
  public void setDefinitionId(String definitionId) {
    this.definitionId = definitionId;
  }

  @JsonProperty("alarm_name")
  public String getName() {
    return name;
  }

  @JsonProperty("alarm_name")
  public void setName(String name) {
    this.name = name;
  }

  @JsonProperty("alarm_description")
  public String getDescription() {
    return description;
  }

  @JsonProperty("alarm_description")
  public void setDescription(String description) {
    this.description = description;
  }

  @JsonProperty("alarm_timestamp")
  public long getTimestamp() {
    return timestamp;
  }

  @JsonProperty("alarm_timestamp")
  public void setTimestamp(long timestamp) {
    this.timestamp = timestamp;
  }

  @JsonProperty("message")
  public String getMessage() {
    return message;
  }

  @JsonProperty("message")
  public void setMessage(String message) {
    this.message = message;
  }

  @JsonProperty("state")
  public AlarmState getState() {
    return state;
  }

  @JsonProperty("state")
  public void setState(AlarmState state) {
    this.state = state;
  }

  @JsonProperty("old_state")
  public AlarmState getOldState() {
    return oldState;
  }

  @JsonProperty("old_state")
  public void setOldState(AlarmState oldState) {
    this.oldState = oldState;
  }

  @JsonProperty("tenant_id")
  public String getTenantId() {
    return tenantId;
  }

  @JsonProperty("tenant_id")
  public void setTenantId(String tenantId) {
    this.tenantId = tenantId;
  }

  @JsonProperty("metrics")
  public List<Metric> getMetrics() {
    return metrics;
  }

  @JsonProperty("metrics")
  public void setMetrics(List<Metric> metrics) {
    this.metrics = metrics;
  }

  public String toString() {
    return MoreObjects.toStringHelper(this).add("id", id).add("definitionId", definitionId)
        .add("name", name).add("description", description).add("timestamp", timestamp)
        .add("message", message).add("state", state).add("oldState", oldState)
        .add("tenantId", tenantId).add("metrics", metrics).toString();
  }
}