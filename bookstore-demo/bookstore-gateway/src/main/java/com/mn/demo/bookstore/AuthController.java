package com.mn.demo.bookstore;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import io.micronaut.views.View;

import java.util.HashMap;
import java.util.Map;

//@Controller("/")
public class AuthController {

    @Secured(SecurityRule.IS_ANONYMOUS)
    @View("login")
    @Get
    public Map<String, Object> index() {
        return new HashMap<>();
    }
}
