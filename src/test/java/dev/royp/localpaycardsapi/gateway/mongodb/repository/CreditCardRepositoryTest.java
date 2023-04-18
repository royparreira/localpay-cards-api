package dev.royp.localpaycardsapi.gateway.mongodb.repository;

import dev.royp.localpaycardsapi.fixture.CreditCardFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.test.StepVerifier;

@DataMongoTest
@ExtendWith(SpringExtension.class)
class CreditCardRepositoryTest {
  @Autowired private CreditCardRepository creditCardRepository;

  @Test
  @DisplayName("Should successfully save a credit card")
  void ShouldSuccessfullySaveACreditCard() {

    var creditCard = CreditCardFixture.getRandomCreditCard();

    creditCardRepository
        .save(creditCard)
        .as(StepVerifier::create)
        .expectNextMatches(savedCreditCard -> savedCreditCard.getId().equals(creditCard.getId()))
        .verifyComplete();
  }

  @Test
  @DisplayName("Should successfully find all credit cards")
  void shouldSuccessfullyFindAllCreditCards() {
    var creditCard1 = CreditCardFixture.getRandomCreditCard();
    var creditCard2 = CreditCardFixture.getRandomCreditCard();

    creditCardRepository.save(creditCard1).block();
    creditCardRepository.save(creditCard2).block();

    creditCardRepository
        .findAll()
        .as(StepVerifier::create)
        .expectNext(creditCard1, creditCard2)
        .verifyComplete();
  }
}
