package dev.royp.localpaycardsapi.gateway.mongodb.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@With
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "credit_cards")
public class CreditCardDocument {

  @MongoId private String id;

  private String customerName;

  private String brand;

  private String number;

  private String cvv;

  private String issuer;
}
