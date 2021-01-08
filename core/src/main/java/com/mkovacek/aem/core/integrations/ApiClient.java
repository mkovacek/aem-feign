package com.mkovacek.aem.core.integrations;

public interface ApiClient {

    <T> T getApiClient(final Class<T> clientClass, final String basePath);

    ApiClientConfig getConfig();

}