package com.mkovacek.aem.core.integrations.faker;

import com.mkovacek.aem.core.integrations.faker.dto.Address;
import com.mkovacek.aem.core.integrations.faker.dto.Response;
import com.mkovacek.aem.core.integrations.faker.dto.Users;

import feign.Param;
import feign.RequestLine;

public interface FakerApi {

    @RequestLine("GET /addresses?_quantity={quantity}")
    Response<Address> addresses(@Param("quantity") long quantity);

    @RequestLine("GET /users?_quantity={quantity}&_gender={gender}")
    Response<Users> users(@Param("quantity") long quantity, @Param("gender") String gender);

}
