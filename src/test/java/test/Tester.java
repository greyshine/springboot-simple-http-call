package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

class Tester {

    @Test
    void test() {

        final var restClient = RestClient.create();

        final var address = "http://localhost:8080/test-get";
        final var uri = UriComponentsBuilder.fromHttpUrl(address).build().toUri();

        final var result =
                restClient.get()
                        .uri(uri)
                        .retrieve()
                        .body(String.class);

        Assertions.assertEquals( "works", result );
    }
}