package com.mn.demo.bookstore;

import io.micronaut.security.authentication.*;
import io.reactivex.Flowable;
import org.reactivestreams.Publisher;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.Arrays;

@Singleton
public class BookStoreAuthProvider implements AuthenticationProvider {
    @Override
    public Publisher<AuthenticationResponse> authenticate(AuthenticationRequest authenticationRequest) {
        if (authenticationRequest.getIdentity() == null) {
            return Flowable.just(new AuthenticationFailed());
        }
        if (authenticationRequest.getSecret() == null) {
            return Flowable.just(new AuthenticationFailed());
        }
        if (Arrays.asList("user1", "user2").contains(authenticationRequest.getIdentity().toString()) && authenticationRequest.getSecret().equals("maryhadalittlelambherfleecewaswhiteassnow"))     {
            return Flowable.just(new UserDetails(authenticationRequest.getIdentity().toString(), new ArrayList<>()));
        }
        return Flowable.just(new AuthenticationFailed());
    }
}
