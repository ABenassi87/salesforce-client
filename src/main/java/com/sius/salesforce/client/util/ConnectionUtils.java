package com.sius.salesforce.client.util;

import com.sforce.ws.ConnectorConfig;
import com.sius.salesforce.client.dto.InstanceParameters;
import org.apache.commons.lang3.StringUtils;

public class ConnectionUtils {

    public static ConnectorConfig createConnectorConfig(InstanceParameters instanceParameters, APIType type, boolean traceMessages) {
        ConnectorConfig config = new ConnectorConfig();
        // TODO: set proxy!
        config.setTraceMessage(traceMessages);
        config.setUsername(instanceParameters.getUsername());
        config.setPassword(instanceParameters.getPassword() + instanceParameters.getSecurityToken());

        String authEndpoint = "";
        String serviceEndpoint = "";

        switch (type) {
            case PARTNER:
                authEndpoint = instanceParameters.getSoapAPIUrl();
                serviceEndpoint = instanceParameters.getPartnerServiceEndpoint();
                break;
            case METADATA:
                authEndpoint = instanceParameters.getMetadataAPIUrl();
                serviceEndpoint = instanceParameters.getMetadataServiceEndpoint();
                break;
            case APEX:
                authEndpoint = instanceParameters.getApexAPIUrl();
                serviceEndpoint = instanceParameters.getApexServiceEndpoint();
                break;

        }
        if (StringUtils.isNotBlank(authEndpoint))
            config.setAuthEndpoint(authEndpoint);

        if (StringUtils.isNotBlank(serviceEndpoint))
            config.setServiceEndpoint(serviceEndpoint);

        if (StringUtils.isNotBlank(instanceParameters.getSessionId()))
            config.setSessionId(instanceParameters.getSessionId());

        return config;
    }
}
