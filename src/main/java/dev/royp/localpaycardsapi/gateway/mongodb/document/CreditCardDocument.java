package dev.royp.localpaycardsapi.gateway.mongodb.document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "credit_cards")
public class CreditCardDocument {

  @MongoId private String id;

  @NotBlank private String holderName;

  @NotBlank private String brand;

  @Pattern(regexp = "\\d{16}", message = "The card number must contain 16 digits")
  private String number;

  @Pattern(regexp = "\\d{3}", message = "The card cvv must contain 3 digits")
  private String cvv;

  private String issuer;
}
