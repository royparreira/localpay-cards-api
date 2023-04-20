package dev.royp.localpaycardsapi.usecase.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import dev.royp.localpaycardsapi.domain.CreditCard;
import fixture.dev.royp.localpaycardsapi.domain.CreditCardFixture;
import fixture.dev.royp.localpaycardsapi.gateway.mongodb.document.CreditCardDocumentFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class CreditCardMapperTest {

  CreditCardMapper creditCardMapper = Mappers.getMapper(CreditCardMapper.class);

  @Test
  @DisplayName("Should successfully map CreditCard domain to document")
  void ShouldSuccessfullyMapCreditCardDomainToDocument() {

    var creditCard = CreditCardFixture.getValidCreditCardRequestBody();
    var expectedCreditCardDocument = CreditCardDocumentFixture.getValidCreditCardDocument();

    var mappedCreditCardDocument = creditCardMapper.mapToCreditCardDocument(creditCard);

    assertThat(mappedCreditCardDocument)
        .usingRecursiveComparison()
        .ignoringFields("id")
        .isEqualTo(expectedCreditCardDocument);
  }

  @Test
  @DisplayName("Should generate string uuid for CreditCardDocument.id")
  void ShouldGenerateStringUuidForCreditCardDocumentId() {

    var creditCard = new CreditCard();

    var mappedCreditCardDocument = creditCardMapper.mapToCreditCardDocument(creditCard);

    assertThat(mappedCreditCardDocument.getId())
        .as("Assert creditCardDocument.id was generated as string UUID")
        .isInstanceOfAny(String.class)
        .matches(
            stringId ->
                stringId.matches("[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}"));
  }

  @Test
  @DisplayName("Should map CreditCardDocument to CreditCard")
  void ShouldMapCreditCardDocumentToCreditCard() {

    final String UUID = "3ec04a15-59eb-4652-8c5e-a9aaa796b5b0";

    var expectedCreditCard = CreditCardFixture.getValidCreditCardWithId(UUID);
    var creditCardDocument = CreditCardDocumentFixture.getValidCreditCardDocumentWithId(UUID);

    var mappedCreditCardDocument = creditCardMapper.mapToCreditCard(creditCardDocument);

    assertThat(mappedCreditCardDocument).usingRecursiveComparison().isEqualTo(expectedCreditCard);
  }
}
