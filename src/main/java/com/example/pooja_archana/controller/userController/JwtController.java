package com.example.pooja_archana.controller.userController;

import com.example.pooja_archana.dto.request.AddUserRequest;
import com.example.pooja_archana.dto.request.GoogleRequest;
import com.example.pooja_archana.dto.response.ResponseWrapper;
import com.example.pooja_archana.model.UserEntity;
import com.example.pooja_archana.repository.UserRepository;
import com.example.pooja_archana.service.UserService;
import com.example.pooja_archana.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class JwtController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/signup")
    public Map signup(@RequestBody AddUserRequest user) {
        return userService.signup(user);
    }

    @PostMapping("/login")
    public Map login(@RequestBody UserEntity authenticationRequest) throws Exception{
        Map<String, String> mp = new HashMap<>();

        authenticate(authenticationRequest.getEmail(),authenticationRequest.getPassword());
        final UserDetails userDetails = userService.loadUserByUsername(authenticationRequest.getEmail());
        final String token =jwtUtil.generateToken(userDetails);

        UserEntity user =userService.findByEmail(authenticationRequest.getEmail());
        if(user==null){
            mp.put("error","Invalid credentials");
            return mp;
        }
        mp.put("token",token);
        mp.put("userId", String.valueOf(user.getUid()));
        return mp;
    }

    @PostMapping("/gAuth")
    public Map gAuth(@RequestBody GoogleRequest googleRequest) throws Exception {
        Map<String,String> mp = new HashMap<>();
        UserEntity user = userRepository.findByEmail(googleRequest.getEmail());
        if(user == null) {
            UserEntity u = new UserEntity();
            u.setEmail(googleRequest.getEmail());
            u.setName(googleRequest.getFirstName());
            u.setGender(googleRequest.getGender());
            userRepository.save(u);
        }
        final UserDetails userDetails = userService.loadUserByUsername(googleRequest.getEmail());
        final String token =jwtUtil.generateToken(userDetails);

        UserEntity newUser =userService.findByEmail(googleRequest.getEmail());
        if(newUser == null){
            mp.put("error","Invalid Credentials");
        }
        mp.put("token",token);
        mp.put("userId",String.valueOf(newUser.getUid()));
        return mp;
    }

    private void authenticate(String userName, String password) throws Exception {
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName,password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED",e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS",e);
        }
    }
}
