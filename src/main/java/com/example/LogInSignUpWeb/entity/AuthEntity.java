package com.example.LogInSignUpWeb.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection="AuthTable")
public class AuthEntity {
    @Id
    private String id;
    private String username;
    private String email;
//    private String password;
//    private String token;
}
