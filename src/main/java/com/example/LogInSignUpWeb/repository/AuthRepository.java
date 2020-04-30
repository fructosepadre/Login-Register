package com.example.LogInSignUpWeb.repository;

import com.example.LogInSignUpWeb.entity.AuthEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthRepository extends MongoRepository<AuthEntity,String> {
    List<AuthEntity> findByUsername(String username);

    List<AuthEntity> findByEmail(String email);

    AuthEntity findOneByUsername(String username);

    AuthEntity findOneByEmail(String email);
}
