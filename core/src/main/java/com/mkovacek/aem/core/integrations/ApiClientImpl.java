package com.mkovacek.aem.core.integrations;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.metatype.annotations.Designate;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;

@Component(service = ApiClient.class, immediate = true)
@Designate(ocd = ApiClientConfig.class)
public class ApiClientImpl implements ApiClient {

    private ApiClientConfig config;
    private Feign.Builder feignBuilder;

    @Activate
    @Modified
    public void init(final ApiClientConfig config) {
        this.config = config;
        this.initFeignBuilder();
    }

    @Override
    public <T> T getApiClient(final Class<T> clientClass, final String basePath) {
        return this.feignBuilder.target(clientClass, basePath);
    }

    @Override
    public ApiClientConfig getConfig() {
        return this.config;
    }

    private void initFeignBuilder() {
        this.feignBuilder = Feign.builder().client(new OkHttpClient()).encoder(new JacksonEncoder()).decoder(new JacksonDecoder());
    }

}