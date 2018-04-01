package com.b2w.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.b2w.model.Planeta;

public interface PlanetaRepository extends MongoRepository<Planeta, String>, QuerydslPredicateExecutor<Planeta> {

}
