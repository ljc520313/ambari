/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.ambari.server.agent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ambari.server.Role;
import org.apache.ambari.server.RoleCommand;
import org.codehaus.jackson.annotate.JsonProperty;


/**
 * Execution commands are scheduled by action manager, and these are
 * persisted in the database for recovery.
 */
public class ExecutionCommand extends AgentCommand {

  public ExecutionCommand() {
    super(AgentCommandType.EXECUTION_COMMAND);
  }
  private String clusterName;
  private String commandId;
  private String hostname;
  private Role role;
  private Map<String, String> hostLevelParams = new HashMap<String, String>();
  private Map<String, String> roleParams = null;
  private RoleCommand roleCommand;
  private Map<String, List<String>> clusterHostInfo = 
      new HashMap<String, List<String>>();
  private Map<String, Map<String, String>> configurations;
  private String serviceName;
  
  @JsonProperty("commandId")
  public String getCommandId() {
    return this.commandId;
  }
  
  @JsonProperty("commandId")
  public void setCommandId(String commandId) {
    this.commandId = commandId;
  }
  
  @Override
  public boolean equals(Object other) {
    if (!(other instanceof ExecutionCommand)) {
      return false;
    }
    ExecutionCommand o = (ExecutionCommand) other;
    return (this.commandId == o.commandId &&
            this.hostname == o.hostname &&
            this.role == o.role &&
            this.roleCommand == o.roleCommand);
  }
  
  @Override
  public String toString() {
    return "Host=" + hostname + ", commandId=" + commandId + ", role=" + role
        + ", command=" + roleCommand;
  }

  @Override
  public int hashCode() {
    return (hostname + commandId + role).hashCode();
  }
    
  @JsonProperty("role")
  public Role getRole() {
    return role;
  }

  @JsonProperty("role")
  public void setRole(Role role) {
    this.role = role;
  }

  @JsonProperty("roleParams")
  public Map<String, String> getRoleParams() {
    return roleParams;
  }

  @JsonProperty("roleParams")
  public void setRoleParams(Map<String, String> roleParams) {
    this.roleParams = roleParams;
  }

  @JsonProperty("roleCommand")
  public RoleCommand getRoleCommand() {
    return roleCommand;
  }

  @JsonProperty("roleCommand")
  public void setRoleCommand(RoleCommand cmd) {
    this.roleCommand = cmd;
  }
  
  @JsonProperty("clusterName")
  public String getClusterName() {
    return clusterName;
  }
  
  @JsonProperty("clusterName")
  public void setClusterName(String clusterName) {
    this.clusterName = clusterName;
  }

  @JsonProperty("hostname")
  public String getHostname() {
    return hostname;
  }

  @JsonProperty("hostname")
  public void setHostname(String hostname) {
    this.hostname = hostname;
  }

  @JsonProperty("hostLevelParams")
  public Map<String, String> getHostLevelParams() {
    return hostLevelParams;
  }

  @JsonProperty("hostLevelParams")
  public void setHostLevelParams(Map<String, String> params) {
    this.hostLevelParams = params;
  }

  @JsonProperty("clusterHostInfo")
  public Map<String, List<String>> getClusterHostInfo() {
    return clusterHostInfo;
  }

  @JsonProperty("clusterHostInfo")
  public void setClusterHostInfo(Map<String, List<String>> clusterHostInfo) {
    this.clusterHostInfo = clusterHostInfo;
  }
  
  @JsonProperty("configurations")
  public Map<String, Map<String, String>> getConfigurations() {
    return configurations;
  }

  @JsonProperty("configurations")
  public void setConfigurations(Map<String, Map<String, String>> configurations) {
    this.configurations = configurations;
  }

  @JsonProperty("serviceName")
  public String getServiceName() {
    return serviceName;
  }

  @JsonProperty("serviceName")
  public void setServiceName(String serviceName) {
    this.serviceName = serviceName;
  }
}
