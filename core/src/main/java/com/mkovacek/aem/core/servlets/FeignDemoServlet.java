package com.mkovacek.aem.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletPaths;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.mkovacek.aem.core.integrations.ApiClient;
import com.mkovacek.aem.core.integrations.faker.FakerApi;
import com.mkovacek.aem.core.integrations.faker.dto.Address;
import com.mkovacek.aem.core.integrations.faker.dto.Response;
import com.mkovacek.aem.core.integrations.faker.dto.Users;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component(service = Servlet.class)
@SlingServletPaths("/bin/feign")
public class FeignDemoServlet extends SlingSafeMethodsServlet {

    @Reference
    private transient ApiClient apiClient;

    @Override
    protected void doGet(final SlingHttpServletRequest request, final SlingHttpServletResponse response) throws ServletException, IOException {
        try {
            final FakerApi fakerApi = this.apiClient.getApiClient(FakerApi.class, this.apiClient.getConfig().fakerApiBasePath());
            final Response<Address> address = fakerApi.addresses(2);
            final Response<Users> femaleUsers = fakerApi.users(2, "female");
            final Response<Users> maleUsers = fakerApi.users(2, "male");

            response.getWriter().write(address.toString());
            response.getWriter().write("\n");
            response.getWriter().write(femaleUsers.toString());
            response.getWriter().write("\n");
            response.getWriter().write(maleUsers.toString());
        } catch (final Exception e) {
            log.error("Exception in doGet method", e);
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

}