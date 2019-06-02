package com.example.demo.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import com.example.demo.model.PersonModel;

public interface PersonRepository extends Neo4jRepository<PersonModel, Long> {
    PersonModel findByName(String name);
}