package com.example.pooja_archana.service;

import com.example.pooja_archana.dto.request.AddUserRequest;
import com.example.pooja_archana.model.UserEntity;
import com.example.pooja_archana.repository.UserRepository;
import com.example.pooja_archana.utils.ErrorMessages;
import com.example.pooja_archana.utils.SuccessMessages;
import com.example.pooja_archana.utils.converter.RequestToEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService implements SuccessMessages, ErrorMessages, UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(UserService.class);
    private RequestToEntity requestToEntity = new RequestToEntity();

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        //Called everytime when someone tries to authenticate.
        System.out.println(email);
        UserEntity user =userRepository.findByEmail(email);
        System.out.println(user);
        if(user==null) {
            throw new UsernameNotFoundException("User: "+email+" not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>());
    }

    public Map signup(AddUserRequest user) {
        Map<String,Object> mp = new HashMap<>();
        UserEntity userEntity=requestToEntity.addUserToEntity(user);
        UserEntity u = userRepository.findByEmail(userEntity.getEmail());
        System.out.println("User = "+u);
        if(u!=null) {
            logger.error(USER_EXISTS);
            mp.put("Success","False");
            mp.put("Message",USER_EXISTS);
            return mp;
        }
        userEntity.setPassword(bcryptEncoder.encode(userEntity.getPassword()));
        userRepository.save(userEntity);
        mp.put("Success","True");
        mp.put("Message",USER_ADD_SUCCESS);
        mp.put("User",userEntity);
        return mp;
    }

    public UserEntity findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
