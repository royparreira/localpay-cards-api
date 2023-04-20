package dev.royp.localpaycardsapi.usecase.service;

import dev.royp.localpaycardsapi.domain.CreditCard;
import reactor.core.publisher.Mono;

public interface ICreditCardService {
  Mono<CreditCard> saveCreditCard(CreditCard creditCard);
}
