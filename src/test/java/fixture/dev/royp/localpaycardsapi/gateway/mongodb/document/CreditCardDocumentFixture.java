package fixture.dev.royp.localpaycardsapi.gateway.mongodb.document;

import dev.royp.localpaycardsapi.gateway.mongodb.document.CreditCardDocument;
import fixture.StringFixture;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class CreditCardDocumentFixture {
  private CreditCardDocumentFixture() {}

  public static final int CVV_QUANTITY_OF_DIGITS = 3;
  public static final int CARD_NUMBER_QUANTITY_OF_DIGITS = 16;

  public static CreditCardDocument getRandomCreditCardDocument() {
    return CreditCardDocument.builder()
        .id(StringFixture.getRandomStringUUID())
        .customerName(StringFixture.getRandomFullName())
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
    return StringFixture.getRandomLongNumericStringWithSize(CARD_NUMBER_QUANTITY_OF_DIGITS);
  }

  public static String getRandomCVV() {
    return StringFixture.getRandomLongNumericStringWithSize(CVV_QUANTITY_OF_DIGITS);
  }

  public static CreditCardDocument getValidCreditCardDocument() {

    return CreditCardDocument.builder()
        .customerName("John Doe")
        .brand("Master Card")
        .number("1365897502368541")
        .cvv("889")
        .build();
  }

  public static CreditCardDocument getValidCreditCardDocumentWithId(String stringUuid) {

    var creditCardDocument = getValidCreditCardDocument();
    creditCardDocument.setId("3ec04a15-59eb-4652-8c5e-a9aaa796b5b0");

    return creditCardDocument;
  }

  public static List<CreditCardDocument> getAListOfRandomCreditCardDocument(int size) {
    List<CreditCardDocument> randomCreditCardDocumentList = new ArrayList<>();

    IntStream.range(0, size)
        .forEach(i -> randomCreditCardDocumentList.add(getRandomCreditCardDocument()));

    return randomCreditCardDocumentList;
  }
}
