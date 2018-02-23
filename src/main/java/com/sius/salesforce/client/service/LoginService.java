package com.sius.salesforce.client.service;

import com.sius.salesforce.client.dto.InstanceCredentials;

public interface LoginService {

    void login(InstanceCredentials credentials);
    void logout();
    void clearConnection();
}
