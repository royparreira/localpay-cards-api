package dev.royp.localpaycardsapi.usecase.service;

import dev.royp.localpaycardsapi.domain.CreditCard;
import dev.royp.localpaycardsapi.gateway.mongodb.repository.CreditCardRepository;
import dev.royp.localpaycardsapi.usecase.mapper.CreditCardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CreditCardServiceImpl implements ICreditCardService {

  private final CreditCardMapper creditCardMapper;
  private final CreditCardRepository creditCardRepository;

  @Override
  public Mono<CreditCard> saveCreditCard(CreditCard creditCard) {
    var creditCardDocument = creditCardMapper.mapToCreditCardDocument(creditCard);
    return creditCardRepository.save(creditCardDocument).map(creditCardMapper::mapToCreditCard);
  }
}
