package com.example.LogInSignUpWeb.controller;

import com.example.LogInSignUpWeb.dto.LogInDTO;
import com.example.LogInSignUpWeb.dto.SignUpDTO;
import com.example.LogInSignUpWeb.service.LogInInterface;
import com.example.LogInSignUpWeb.service.SignUpInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/75percent/web")
public class Auth {

    @Autowired
    private LogInInterface logInInterface;

    @Autowired
    private SignUpInterface signUpInterface;

    @PostMapping(value = "/register")
    private String register(@RequestBody SignUpDTO signUpDTO){
        return signUpInterface.addUser(signUpDTO);
    }

    @PostMapping(value = "/login")
    private String logIn(@RequestBody LogInDTO logInDTO){
        System.out.println(logInInterface.checkForLogIn(logInDTO));
        return logInInterface.checkForLogIn(logInDTO);
    }

}
