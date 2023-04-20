package dev.royp.localpaycardsapi.gateway.mongodb.repository;

import static fixture.dev.royp.localpaycardsapi.gateway.mongodb.document.CreditCardDocumentFixture.getAListOfRandomCreditCardDocument;

import fixture.dev.royp.localpaycardsapi.gateway.mongodb.document.CreditCardDocumentFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import reactor.test.StepVerifier;

@DataMongoTest
class CreditCardRepositoryTest {
  @Autowired private CreditCardRepository creditCardRepository;

  @Test
  @DisplayName("Should successfully save a credit card")
  void shouldSuccessfullySaveACreditCard() {

    var creditCard = CreditCardDocumentFixture.getRandomCreditCardDocument();

    creditCardRepository
        .save(creditCard)
        .as(StepVerifier::create)
        .expectNextMatches(savedCreditCard -> savedCreditCard.getId().equals(creditCard.getId()))
        .expectComplete()
        .verify();
  }

  @Test
  @DisplayName("Should successfully find all credit cards")
  void shouldSuccessfullyFindAllCreditCards() {

    var creditCardMongoDocuments = getAListOfRandomCreditCardDocument(2);

    creditCardRepository
        .saveAll(creditCardMongoDocuments)
        .flatMap(any -> creditCardRepository.findAll())
        .collectList()
        .as(StepVerifier::create)
        .expectNextMatches(
            retrievedCreditCards -> retrievedCreditCards.containsAll(creditCardMongoDocuments))
        .expectComplete()
        .verify();
  }
}
