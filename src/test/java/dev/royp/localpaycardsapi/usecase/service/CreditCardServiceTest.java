package dev.royp.localpaycardsapi.usecase.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;

import dev.royp.localpaycardsapi.gateway.mongodb.repository.CreditCardRepository;
import dev.royp.localpaycardsapi.usecase.mapper.CreditCardMapper;
import fixture.dev.royp.localpaycardsapi.domain.CreditCardFixture;
import fixture.dev.royp.localpaycardsapi.gateway.mongodb.document.CreditCardDocumentFixture;
import java.util.Objects;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@ExtendWith(MockitoExtension.class)
class CreditCardServiceTest {

  @Mock private CreditCardRepository creditCardRepository;
  @Spy private CreditCardMapper creditCardMapper = Mappers.getMapper(CreditCardMapper.class);

  @InjectMocks CreditCardServiceImpl creditCardService;

  @Test
  @DisplayName("Should successfully save credit card info by invoking repository")
  void ShouldSuccessfullySaveCreditCardInfoByInvokingRepository() {

    var creditCardDocument = CreditCardDocumentFixture.getRandomCreditCardDocument();
    var creditCard = CreditCardFixture.getValidCreditCardRequestBody();

    Mockito.when(creditCardRepository.save(any())).thenReturn(Mono.just(creditCardDocument));
    Mockito.when(creditCardMapper.mapToCreditCard(any())).thenReturn(creditCard);
    Mockito.when(creditCardMapper.mapToCreditCardDocument(any())).thenReturn(creditCardDocument);

    creditCardService
        .saveCreditCard(creditCard)
        .as(StepVerifier::create)
        .expectNextMatches(Objects::nonNull)
        .verifyComplete();

    Mockito.verify(creditCardRepository, times(1)).save(creditCardDocument);
    Mockito.verify(creditCardMapper, times(1)).mapToCreditCard(creditCardDocument);
    Mockito.verify(creditCardMapper, times(1)).mapToCreditCardDocument(creditCard);
  }
}
