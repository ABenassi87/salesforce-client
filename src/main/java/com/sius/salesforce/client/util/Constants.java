package com.sius.salesforce.client.util;

import java.io.File;

public class Constants {

    public static final String DEFAULT_API_VERSION = "v42.0";
    public static final String DEFAULT_API_VERSION_NUMBER = "42.0";
    public static final String SERVICES_URI = "/services/data/";
    public static final String SOBJECTS_PATH = "/sobjects/";
    public static final String DESCRIBE_PATH = "/describe/";
    public static final String SOBJECTS = "sobjects";
    public static final String QUERY = "query";
    public static final String SEARCH = "search";
    public static final String RECENT = "recent";
    public static final String QUERY_PATH = "/query/";

    public static final String LIMITS = "/limits/";

    public static final String TOOLING_PATH = "/tooling";
    public static final String TOOLING_BASE_URI = SERVICES_URI + DEFAULT_API_VERSION + TOOLING_PATH;
    public static final String EXECUTE_ANONYMOUS_PATH = TOOLING_BASE_URI + "/executeAnonymous/";

    public static final String SOBJECTS_BASE_PATH = TOOLING_BASE_URI + SOBJECTS_PATH;
    public static final String CODE_COVERAGE_PATH = SOBJECTS_BASE_PATH + "ApexCodeCoverage/";
    public static final String CODE_COVERAGE_AGGREGATE_PATH = SOBJECTS_BASE_PATH + "ApexCodeCoverageAggregate/";

    public static final String GZIP = "gzip";
    public static final String DEFLATE = "deflate";

    public static final String ACCEPT_ENCODING = "Accept-Encoding";
    public static final String ENCODING = "gzip,deflate";

    public static final String AUTHORIZATION = "Authorization";
    public static final String BEARER = "Bearer ";
    public static final String HTTPS = "https";
    public static final int PORT_443 = 443;

    public static final String PRODUCTION_DE = "Production / Developer Edition";
    public static final String SANDBOX = "Sandbox";
    public static final String PRE_RELEASE = "Pre-Release";
    public static final String OTHER = "Other";


    /* Endpoints*/
    public static final String SOAP_PATH = "/services/Soap/";
    public static final String PARTNER_CHARACTER = "u";
    public static final String METADATA_CHARACTER = "m";
    public static final String ENTERPRISE_CHARACTER = "c";
    public static final String APEX_CHARACTER = "s";
    public static final String PARTNER_PATH = SOAP_PATH+PARTNER_CHARACTER;
    public static final String METADATA_PATH = SOAP_PATH+METADATA_CHARACTER;
    public static final String APEX_PATH = SOAP_PATH+APEX_CHARACTER;

    public static final String PARTNER_URL = PARTNER_PATH+"/"+DEFAULT_API_VERSION_NUMBER+"/";
    public static final String METADATA_URL = METADATA_PATH+"/"+DEFAULT_API_VERSION_NUMBER+"/";
    public static final String ENTERPRISE_PATH = SOAP_PATH+ENTERPRISE_CHARACTER+"/"+DEFAULT_API_VERSION_NUMBER+"/";
    public static final String APEX_URL = APEX_PATH+"/"+DEFAULT_API_VERSION_NUMBER+"/";
    public static final String REST_URL = SERVICES_URI+"/";
    public static final String SOBJECTS_URL = REST_URL+SOBJECTS+"/";
    public static final String SEARCH_URL = REST_URL+SEARCH+"/";
    public static final String QUERY_URL = REST_URL+QUERY+"/";
    public static final String RECENT_URL = REST_URL+RECENT+"/";


    /*
    "enterprise":"https://na1.salesforce.com/services/Soap/c/{version}/00D50000000IZ3Z",
		"metadata":"https://na1.salesforce.com/services/Soap/m/{version}/00D50000000IZ3Z",
		"partner":"https://na1.salesforce.com/services/Soap/u/{version}/00D50000000IZ3Z",
		"rest":"https://na1.salesforce.com/services/data/v{version}/",
		"sobjects":"https://na1.salesforce.com/services/data/v{version}/sobjects/",
		"search":"https://na1.salesforce.com/services/data/v{version}/search/",
		"query":"https://na1.salesforce.com/services/data/v{version}/query/",
		"recent":"https://na1.salesforce.com/services/data/v{version}/recent/",
    * */
}
