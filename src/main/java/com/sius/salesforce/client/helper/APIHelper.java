package com.sius.salesforce.client.helper;

import com.sforce.ws.ConnectionException;
import com.sius.salesforce.client.dto.InstanceParameters;
import com.sius.salesforce.client.handler.ApexConnectionHandler;
import com.sius.salesforce.client.handler.MetadataConnectionHandler;
import com.sius.salesforce.client.handler.PartnerConnectionHandler;

public class APIHelper {

    private PartnerConnectionHandler partnerConnectionHandler;
    private MetadataConnectionHandler metadataConnectionHandler;
    private ApexConnectionHandler apexConnectionHandler;

    public APIHelper(InstanceParameters credentials) throws ConnectionException {
        this.partnerConnectionHandler = new PartnerConnectionHandler(credentials);
        credentials.setPartnerServiceEndpoint(partnerConnectionHandler.getServiceEndpoint());
        credentials.setSessionId(partnerConnectionHandler.getSessionId());
        this.metadataConnectionHandler = new MetadataConnectionHandler(credentials);
        this.apexConnectionHandler = new ApexConnectionHandler(credentials);

    }


    public void clearAllConnections() {
        this.apexConnectionHandler.closeConnection();
        this.metadataConnectionHandler.closeConnection();
        this.partnerConnectionHandler.closeConnection();
    }

    public PartnerConnectionHandler getPartnerConnectionHandler() {
        return partnerConnectionHandler;
    }

    public MetadataConnectionHandler getMetadataConnectionHandler() {
        return metadataConnectionHandler;
    }

    public ApexConnectionHandler getApexConnectionHandler() {
        return apexConnectionHandler;
    }
}
