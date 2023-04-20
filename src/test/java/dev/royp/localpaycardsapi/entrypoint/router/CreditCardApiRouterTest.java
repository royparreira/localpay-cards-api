package dev.royp.localpaycardsapi.entrypoint.router;

import dev.royp.localpaycardsapi.config.properties.ApiRouteProperties;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.reactive.server.WebTestClient;

@WebFluxTest
@ContextConfiguration(classes = {CreditCardApiRouter.class, ApiRouteProperties.class})
@DisplayName("Credit Card API Router Tests")
class CreditCardApiRouterTest {

  public static final String EXPECTED_CREDIT_CARDS_ROUTE = "/credit_cards";
  public static final String EXPECTED_CREDIT_CARDS_ID_ROUTE = "/credit_cards/fakeId";

  @Autowired private WebTestClient webTestClient;

  @Test
  @DisplayName("Should successfully route POST /credit_cards")
  void shouldSuccessfullyRoutePostCreditCards() {

    webTestClient
        .post()
        .uri(EXPECTED_CREDIT_CARDS_ROUTE)
        .accept(MediaType.APPLICATION_JSON)
        .exchange()
        .expectStatus()
        .isCreated();
  }

  @Test
  @DisplayName("Should successfully route GET /credit_cards")
  void shouldSuccessfullyRouteGetAllCreditCards() {

    webTestClient
        .get()
        .uri(EXPECTED_CREDIT_CARDS_ROUTE)
        .accept(MediaType.APPLICATION_JSON)
        .exchange()
        .expectStatus()
        .isOk();
  }

  @Test
  @DisplayName("Should successfully route GET /credit_cards/{credit_card_id}")
  void shouldSuccessfullyRouteGetCreditCardById() {

    webTestClient
        .get()
        .uri(EXPECTED_CREDIT_CARDS_ID_ROUTE)
        .accept(MediaType.APPLICATION_JSON)
        .exchange()
        .expectStatus()
        .isOk();
  }

  @Test
  @DisplayName("Should successfully route PUT /credit_cards/{credit_card_id}")
  void shouldSuccessfullyRoutePutCreditCard() {

    webTestClient
        .put()
        .uri(EXPECTED_CREDIT_CARDS_ID_ROUTE)
        .accept(MediaType.APPLICATION_JSON)
        .exchange()
        .expectStatus()
        .isOk();
  }

  @Test
  @DisplayName("Should successfully route DELETE /credit_cards/{credit_card_id}")
  void shouldSuccessfullyRouteDeleteCreditCard() {

    webTestClient
        .delete()
        .uri(EXPECTED_CREDIT_CARDS_ID_ROUTE)
        .accept(MediaType.APPLICATION_JSON)
        .exchange()
        .expectStatus()
        .isOk();
  }
}
