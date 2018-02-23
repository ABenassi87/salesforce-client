/*
 * Copyright 2014 Mark Borner
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sius.salesforce.client.dto;

import com.sius.salesforce.client.util.Constants;
import com.sius.salesforce.client.util.LoginEnvironments;
import org.apache.commons.lang3.StringUtils;

import static com.sius.salesforce.client.util.Constants.METADATA_PATH;
import static com.sius.salesforce.client.util.Constants.PARTNER_PATH;
import static com.sius.salesforce.client.util.Constants.TOOLING_BASE_URI;

/**
 * A container to hold the credentials for a Salesforce instance
 *
 * @author Mark Borner (gzhomzb)
 */
public class InstanceParameters {

    private String name;
    private String username;
    private String password;
    private String securityToken;
    private String environment;
    private String otherUrl;
    private String partnerServiceEndpoint;
    private String metadataServiceEndpoint;
    private String apexServiceEndpoint;
    private String toolingServiceEndpoint;
    private String sessionId;
    private boolean retrievedFromSafe = false;

    public InstanceParameters() {
    }

    public InstanceParameters(String name) {
        this.name = name;
    }

    public InstanceParameters(InstanceParameters other) {
        this.name = other.name;
        this.username = other.username;
        this.password = other.password;
        this.securityToken = other.securityToken;
        this.environment = other.environment;
        this.otherUrl = other.otherUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSecurityToken() {
        return securityToken;
    }

    public void setSecurityToken(String securityToken) {
        this.securityToken = securityToken;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getOtherUrl() {
        return otherUrl;
    }

    public void setOtherUrl(String otherUrl) {
        this.otherUrl = otherUrl;
    }

    public String getPartnerServiceEndpoint() {
        return partnerServiceEndpoint;
    }

    public void setPartnerServiceEndpoint(String partnerServiceEndpoint) {
        this.partnerServiceEndpoint = partnerServiceEndpoint;
    }

    public String getMetadataServiceEndpoint() {
        if(StringUtils.isNotBlank(partnerServiceEndpoint) && StringUtils.isBlank(metadataServiceEndpoint)){
            metadataServiceEndpoint = partnerServiceEndpoint.replace(PARTNER_PATH,METADATA_PATH);
        }

        return metadataServiceEndpoint;
    }

    public String getApexServiceEndpoint() {
        if(StringUtils.isNotBlank(partnerServiceEndpoint) && StringUtils.isBlank(apexServiceEndpoint)){
            apexServiceEndpoint = partnerServiceEndpoint.replace(PARTNER_PATH,METADATA_PATH);
        }
        return apexServiceEndpoint;
    }

    public String getToolingServiceEndpoint() {
        if(StringUtils.isNotBlank(partnerServiceEndpoint) && StringUtils.isBlank(toolingServiceEndpoint)){
            apexServiceEndpoint = partnerServiceEndpoint.replace(PARTNER_PATH,TOOLING_BASE_URI);
        }
        return toolingServiceEndpoint;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getSoapAPIUrl() {
        return LoginEnvironments.getEnviromentURL(environment)+Constants.PARTNER_URL;
    }

    public String getMetadataAPIUrl() {
        return LoginEnvironments.getEnviromentURL(environment)+Constants.METADATA_URL;
    }

    public String getApexAPIUrl() {
        return LoginEnvironments.getEnviromentURL(environment)+Constants.APEX_URL;
    }

    @Override
    public String toString() {
        return String.format("%s|%s|%s|%s|%s|%s|%s|%s", name, username, password, securityToken, environment, otherUrl, sessionId,partnerServiceEndpoint,metadataServiceEndpoint,apexServiceEndpoint);
    }

    public static InstanceParameters fromString(String string) {
        InstanceParameters instance = new InstanceParameters();
        String[] parts = string.split("\\|");
        instance.name = parts[0];
        instance.username = parts[1];
        instance.password = parts[2];
        instance.securityToken = parts[3];
        instance.environment = parts[4];
        if (parts.length == 6) {  // other URL is optional
            instance.otherUrl = parts[5];
        }
        return instance;
    }

    public boolean isRetrievedFromSafe() {
        return retrievedFromSafe;
    }

    public void setRetrievedFromSafe(boolean retrievedFromSafe) {
        this.retrievedFromSafe = retrievedFromSafe;
    }

}
