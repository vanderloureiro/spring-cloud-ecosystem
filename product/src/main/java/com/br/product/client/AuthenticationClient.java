package com.br.product.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("authentication")
public interface AuthenticationClient {

    @RequestMapping(method = RequestMethod.GET, value = "/auth/v1/is-authenticated")
    Boolean isValid(@RequestHeader(value = "Authorization") String token);

}