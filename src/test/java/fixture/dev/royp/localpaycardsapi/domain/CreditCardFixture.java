package fixture.dev.royp.localpaycardsapi.domain;

import dev.royp.localpaycardsapi.domain.CreditCard;

public class CreditCardFixture {
  private CreditCardFixture() {}

  public static CreditCard getValidCreditCardRequestBody() {
    return CreditCard.builder()
        .customerName("John Doe")
        .brand("Master Card")
        .number("1365897502368541")
        .cvv("889")
        .build();
  }

  public static CreditCard getValidCreditCardWithId(String stringUuid) {

    var creditCard = getValidCreditCardRequestBody();
    creditCard.setId(stringUuid);

    return creditCard;
  }
}
