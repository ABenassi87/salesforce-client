package com.sius.salesforce.client.util;

import com.sius.salesforce.client.dto.InstanceParameters;

public class TestUtils {

    public static InstanceParameters createParameters(){
        InstanceParameters parameters = new InstanceParameters();

        parameters.setEnvironment("Production");
        parameters.setUsername("jperez77@yopmail.com");
        parameters.setPassword("Test_123");
        parameters.setSecurityToken("A27yO8nCIUSGvsLA26633LA1");

        return parameters;
    }
}
