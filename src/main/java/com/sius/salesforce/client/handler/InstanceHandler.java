package com.sius.salesforce.client.handler;

import com.sforce.soap.apex.SoapConnection;
import com.sforce.soap.metadata.MetadataConnection;
import com.sforce.soap.partner.PartnerConnection;
import com.sforce.ws.ConnectorConfig;
import com.sius.salesforce.client.dto.InstanceCredentials;
import com.sius.salesforce.client.util.LoginEnvironments;

public class InstanceHandler {
    private PartnerConnection partnerConnection;
    private MetadataConnection metadataConnection;
    private SoapConnection apexConnection;

    public InstanceHandler(InstanceCredentials credentials) {

    }

    /*private PartnerConnection createPartnerConnextion(ConnectorConfig loginConfig){}*/

    private ConnectorConfig createConnectorConfig(InstanceCredentials instanceCredentials, boolean traceMessages) {
        ConnectorConfig config = new ConnectorConfig();
        // TODO: set proxy!
        config.setTraceMessage(traceMessages);
        config.setUsername(instanceCredentials.getUsername());
        config.setPassword(instanceCredentials.getPassword() + instanceCredentials.getSecurityToken());
        config.setAuthEndpoint(instanceCredentials.getEnvironment());
        return config;
    }

    public void clearAllConnections() {
        partnerConnection = null;
        metadataConnection = null;
        apexConnection = null;
    }


}
