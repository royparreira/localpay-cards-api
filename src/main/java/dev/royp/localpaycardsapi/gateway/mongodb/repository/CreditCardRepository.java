package dev.royp.localpaycardsapi.gateway.mongodb.repository;

import dev.royp.localpaycardsapi.gateway.mongodb.document.CreditCardDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends ReactiveMongoRepository<CreditCardDocument, String> {}
