package dev.royp.localpaycardsapi.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreditCard {

  private String id;

  @NotBlank private String customerName;

  @NotBlank private String brand;

  @Pattern(regexp = "\\d{16}", message = "The card number must contain 16 digits")
  private String number;

  @Pattern(regexp = "\\d{3}", message = "The card cvv must contain 3 digits")
  private String cvv;

  private String issuer;
}
