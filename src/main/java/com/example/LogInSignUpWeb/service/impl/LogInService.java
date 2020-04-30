package com.example.LogInSignUpWeb.service.impl;

import com.example.LogInSignUpWeb.dto.LogInDTO;
import com.example.LogInSignUpWeb.entity.AuthEntity;
import com.example.LogInSignUpWeb.repository.AuthRepository;
import com.example.LogInSignUpWeb.service.LogInInterface;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class LogInService implements LogInInterface{

    @Autowired
    private AuthRepository authRepository;

    private boolean checkPresence(AuthEntity authEntity){
        String email=authEntity.getEmail();
        String userName=authEntity.getUsername();
        if (email==null) {
            AuthEntity usernameList = authRepository.findOneByUsername(userName);
            if(usernameList.getPassword().equals(authEntity.getPassword()))
                return true;
        }
        else{
            AuthEntity emailList=authRepository.findOneByEmail(email);
            if(emailList.getPassword().equals(authEntity.getPassword()))
                return true;
        }

        return false;
    }

    @Override
    public String checkForLogIn(LogInDTO logInDTO) {
        String indentifier=logInDTO.getIdentifier();
        AuthEntity authEntity=new AuthEntity();
        if (indentifier.contains("@srmuniv.edu.in"))
            authEntity.setEmail(indentifier);
        else
            authEntity.setUsername(indentifier);

        BeanUtils.copyProperties(logInDTO,authEntity);

        Optional<AuthEntity> indentifierList;

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (indentifier.contains("@srmuniv.edu.in")){
            indentifierList = Optional.ofNullable(authRepository.findOneByEmail(authEntity.getEmail()));}
        else{
            indentifierList = Optional.ofNullable(authRepository.findOneByUsername(authEntity.getUsername()));}

        if (!indentifierList.isPresent())
            return "Create Account";

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(checkPresence(authEntity))
            return "Logged In";

        return "Wrong Credentials";
    }
}
