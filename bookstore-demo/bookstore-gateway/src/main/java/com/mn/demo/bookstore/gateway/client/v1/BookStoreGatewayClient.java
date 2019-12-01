package com.mn.demo.bookstore.gateway.client.v1;

import com.mn.demo.bookstore.service.api.BookOperations;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.retry.annotation.Retryable;


@Client(id = "bookstore", path = "/bookstore")
@Retryable(attempts = "2", delay = "2s")
public interface BookStoreGatewayClient extends BookOperations {
}
