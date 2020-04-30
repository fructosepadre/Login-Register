package com.example.LogInSignUpWeb.service.impl;
import com.example.LogInSignUpWeb.dto.SignUpDTO;
import com.example.LogInSignUpWeb.entity.AuthEntity;
import com.example.LogInSignUpWeb.repository.AuthRepository;
import com.example.LogInSignUpWeb.service.SignUpInterface;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SignUpService implements SignUpInterface{

    @Autowired
    private AuthRepository authRepository;

    private boolean checkPresence(AuthEntity authEntity){
        List<AuthEntity> usernameList=authRepository.findByUsername(authEntity.getUsername());
        List<AuthEntity> emailList=authRepository.findByEmail(authEntity.getEmail());
        if(usernameList.isEmpty() && emailList.isEmpty())
            return false;

        return true;
    }

    @Override
    public String addUser(SignUpDTO signUpDTO) {
        AuthEntity authEntity=new AuthEntity();
        BeanUtils.copyProperties(signUpDTO,authEntity);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(checkPresence(authEntity))
            return "Duplicate";


        authRepository.save(authEntity);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (checkPresence(authEntity))
            return "Registered";

        return "Something Went Wrong";
    }
}
