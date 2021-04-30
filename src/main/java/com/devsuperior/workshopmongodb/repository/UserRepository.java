package com.devsuperior.workshopmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.workshopmongodb.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
