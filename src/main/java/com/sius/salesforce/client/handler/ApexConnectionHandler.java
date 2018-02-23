package com.sius.salesforce.client.handler;

import com.sforce.soap.apex.Connector;
import com.sforce.soap.apex.SoapConnection;
import com.sforce.ws.ConnectionException;
import com.sforce.ws.ConnectorConfig;
import com.sius.salesforce.client.dto.InstanceParameters;
import com.sius.salesforce.client.util.APIType;
import com.sius.salesforce.client.util.ConnectionUtils;

public class ApexConnectionHandler {
    private SoapConnection apexConnection;

    public ApexConnectionHandler(InstanceParameters credentials) throws ConnectionException {
        ConnectorConfig loginConfig = ConnectionUtils.createConnectorConfig(credentials, APIType.APEX,true);
        apexConnection = Connector.newConnection(loginConfig);
    }

    public SoapConnection getApexConnection() {
        return apexConnection;
    }

    public void setApexConnection(SoapConnection apexConnection) {
        this.apexConnection = apexConnection;
    }

    public void closeConnection(){
        this.apexConnection = null;
    }
}
