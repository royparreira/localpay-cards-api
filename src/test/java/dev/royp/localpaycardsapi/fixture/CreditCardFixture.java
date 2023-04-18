package dev.royp.localpaycardsapi.fixture;

import static dev.royp.localpaycardsapi.fixture.StringFixture.getRandomFullName;
import static dev.royp.localpaycardsapi.fixture.StringFixture.getRandomNumericStringWithSize;
import static dev.royp.localpaycardsapi.fixture.StringFixture.getRandomStringUUID;

import dev.royp.localpaycardsapi.gateway.mongodb.document.CreditCardDocument;

public class CreditCardFixture {
  private CreditCardFixture() {}

  public static final int CVV_QUANTITY_OF_DIGITS = 3;
  public static final int CARD_NUMBER_QUANTITY_OF_DIGITS = 16;

  public static CreditCardDocument getRandomCreditCard() {
    return CreditCardDocument.builder()
        .id(getRandomStringUUID())
        .holderName(getRandomFullName())
        .brand(getRandomCreditCardBrand())
        .number(getRandomCardNumber())
        .cvv(getRandomCVV())
        .issuer(getRandomCreditCardIssuer())
        .build();
  }

  public static String getRandomCreditCardBrand() {
    String[] creditCardBrands = {
      "Visa", "Mastercard", "American Express", "Discover", "China UnionPay", "JCB"
    };
    return creditCardBrands[(int) (Math.random() * creditCardBrands.length)];
  }

  public static String getRandomCreditCardIssuer() {
    String[] creditCardIssuers = {
      "Visa", "Mastercard", "American Express", "Barclays", "HSBC", "Citibank", null
    };
    return creditCardIssuers[(int) (Math.random() * creditCardIssuers.length)];
  }

  public static String getRandomCardNumber() {
    return getRandomNumericStringWithSize(CARD_NUMBER_QUANTITY_OF_DIGITS);
  }

  public static String getRandomCVV() {
    return getRandomNumericStringWithSize(CVV_QUANTITY_OF_DIGITS);
  }
}
