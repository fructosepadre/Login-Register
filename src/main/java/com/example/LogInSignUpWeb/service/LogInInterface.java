package com.example.LogInSignUpWeb.service;


import com.example.LogInSignUpWeb.dto.LogInDTO;

public interface LogInInterface {

    String checkForLogIn(LogInDTO logInDTO);
}
