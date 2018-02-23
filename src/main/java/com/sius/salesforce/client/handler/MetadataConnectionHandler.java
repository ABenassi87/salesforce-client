package com.sius.salesforce.client.handler;

import com.sforce.soap.metadata.MetadataConnection;
import com.sforce.soap.metadata.Connector;
import com.sforce.ws.ConnectionException;
import com.sforce.ws.ConnectorConfig;
import com.sius.salesforce.client.dto.InstanceParameters;
import com.sius.salesforce.client.util.APIType;
import com.sius.salesforce.client.util.ConnectionUtils;

public class MetadataConnectionHandler {
    private MetadataConnection metadataConnection;

    public MetadataConnectionHandler(InstanceParameters credentials) throws ConnectionException {
        ConnectorConfig loginConfig = ConnectionUtils.createConnectorConfig(credentials, APIType.METADATA,true);
        metadataConnection = Connector.newConnection(loginConfig);
    }

    public MetadataConnection getMetadataConnection() {
        return metadataConnection;
    }

    public void setMetadataConnection(MetadataConnection metadataConnection) {
        this.metadataConnection = metadataConnection;
    }

    public String getSessionId(){
        return metadataConnection.getConfig().getSessionId();
    }

    public String getServiceEndpoint(){
        return metadataConnection.getConfig().getServiceEndpoint();
    }

    public void closeConnection(){
        this.metadataConnection = null;
    }
}
