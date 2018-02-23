package com.sius.salesforce.client.util;

public enum LoginEnvironments {
    PRODUCTION("https://login.salesforce.com/"),
    SANDBOX("https://test.salesforce.com/"),
    PRE_RELEASE("https://prerellogin.pre.salesforce.com/");

    private String environment;

    LoginEnvironments(String environment) {
        this.environment = environment;
    }

    public String getEnvironment() {
        return environment;
    }

    public static String getEnviromentURL(String environment) {
        switch (environment.toUpperCase()) {
            case "PRODUCTION":
                return PRODUCTION.getEnvironment();
            case "SANDBOX":
                return SANDBOX.getEnvironment();
            case "PRE RELEASE":
                return PRE_RELEASE.getEnvironment();
            default:
                return null;

        }
    }

    @Override
    public String toString() {
        return this.environment;
    }
}
