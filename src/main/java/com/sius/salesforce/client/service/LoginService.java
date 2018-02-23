package com.sius.salesforce.client.service;

import com.sius.salesforce.client.dto.InstanceParameters;

public interface LoginService {

    void login(InstanceParameters credentials);
    void logout();
    void clearConnection();
}
