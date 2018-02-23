package com.sius.salesforce.client.handler;

import com.sforce.soap.partner.Connector;
import com.sforce.soap.partner.PartnerConnection;
import com.sforce.ws.ConnectionException;
import com.sforce.ws.ConnectorConfig;
import com.sius.salesforce.client.dto.InstanceParameters;
import com.sius.salesforce.client.util.APIType;
import com.sius.salesforce.client.util.ConnectionUtils;

public class PartnerConnectionHandler {
    private PartnerConnection partnerConnection;

    public PartnerConnectionHandler(InstanceParameters credentials) throws ConnectionException {
        ConnectorConfig loginConfig = ConnectionUtils.createConnectorConfig(credentials, APIType.PARTNER,true);
        partnerConnection = Connector.newConnection(loginConfig);
    }

    public PartnerConnection getPartnerConnection() {
        return partnerConnection;
    }

    public void setPartnerConnection(PartnerConnection partnerConnection) {
        this.partnerConnection = partnerConnection;
    }

    public String getSessionId(){
        return partnerConnection.getConfig().getSessionId();
    }

    public String getServiceEndpoint(){
        return partnerConnection.getConfig().getServiceEndpoint();
    }

    public void closeConnection(){
        this.partnerConnection = null;
    }
}
