package com.sius.salesforce.client.handler;

import com.sforce.soap.tooling.Connector;
import com.sforce.soap.tooling.ToolingConnection;
import com.sforce.ws.ConnectionException;
import com.sforce.ws.ConnectorConfig;
import com.sius.salesforce.client.dto.InstanceParameters;
import com.sius.salesforce.client.util.APIType;
import com.sius.salesforce.client.util.ConnectionUtils;

public class ToolingConnectionHandler {
    private ToolingConnection toolingConnection;

    public ToolingConnectionHandler(InstanceParameters credentials) throws ConnectionException {
        ConnectorConfig loginConfig = ConnectionUtils.createConnectorConfig(credentials, APIType.PARTNER,true);
        toolingConnection = Connector.newConnection(loginConfig);
    }

    public ToolingConnection getToolingConnection() {
        return toolingConnection;
    }

    public void setToolingConnection(ToolingConnection toolingConnection) {
        this.toolingConnection = toolingConnection;
    }

    public String getSessionId(){
        return toolingConnection.getConfig().getSessionId();
    }

    public String getServiceEndpoint(){
        return toolingConnection.getConfig().getServiceEndpoint();
    }

    public void closeConnection(){
        this.toolingConnection = null;
    }
}
