package com.sius.salesforce.client.helper;

import com.sius.salesforce.client.dto.InstanceParameters;
import com.sius.salesforce.client.util.TestUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class APIHelperTest {

    public void testLogin(){
        try {
            InstanceParameters testParameters = TestUtils.createParameters();
            APIHelper helper = new APIHelper(testParameters);

        } catch (Exception e){
            System.err.println(e);
            Assert.fail();
        }

    }
}
