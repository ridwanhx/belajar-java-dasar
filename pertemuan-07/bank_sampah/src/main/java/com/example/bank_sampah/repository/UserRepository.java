package com.example.bank_sampah.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.bank_sampah.model.User;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);
}
