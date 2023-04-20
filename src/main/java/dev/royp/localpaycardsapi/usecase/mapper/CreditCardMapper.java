package dev.royp.localpaycardsapi.usecase.mapper;

import dev.royp.localpaycardsapi.domain.CreditCard;
import dev.royp.localpaycardsapi.gateway.mongodb.document.CreditCardDocument;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CreditCardMapper {

  @Mapping(target = "id", expression = "java(java.util.UUID.randomUUID().toString())")
  CreditCardDocument mapToCreditCardDocument(CreditCard creditCard);

  @InheritInverseConfiguration(name = "mapToCreditCardDocument")
  CreditCard mapToCreditCard(CreditCardDocument creditCard);
}
