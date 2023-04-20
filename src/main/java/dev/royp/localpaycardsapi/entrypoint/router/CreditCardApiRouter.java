package dev.royp.localpaycardsapi.entrypoint.router;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;

import dev.royp.localpaycardsapi.config.properties.ApiRouteProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class CreditCardApiRouter {

  @Bean
  RouterFunction<ServerResponse> routes(ApiRouteProperties apiRouteProperties) {

    var creditCardsUri = apiRouteProperties.getCreditCardsUri();
    var creditCardsIdUri = apiRouteProperties.getCreditCardsIdUri();

    return RouterFunctions.route(
            POST(creditCardsUri),
            serverRequest -> ServerResponse.status(HttpStatus.CREATED).build())
        .andRoute(
            GET(creditCardsUri), serverRequest -> ServerResponse.status(HttpStatus.OK).build())
        .andRoute(
            GET(creditCardsIdUri), serverRequest -> ServerResponse.status(HttpStatus.OK).build())
        .andRoute(
            PUT(creditCardsIdUri), serverRequest -> ServerResponse.status(HttpStatus.OK).build())
        .andRoute(
            DELETE(creditCardsIdUri),
            serverRequest -> ServerResponse.status(HttpStatus.OK).build());
  }
}
