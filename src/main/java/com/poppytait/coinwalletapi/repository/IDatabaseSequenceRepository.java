package com.poppytait.coinwalletapi.repository;

import com.poppytait.coinwalletapi.model.DatabaseSequence;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IDatabaseSequenceRepository extends MongoRepository<DatabaseSequence, String> {
}
