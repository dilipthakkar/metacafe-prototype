package com.metacube.metacafe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.metacube.metacafe.auth.JwtService;
import com.metacube.metacafe.models.AuthRequest;
import com.metacube.metacafe.service.user.UserService;

@RestController
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired 
    JwtService jwtHelper;

    @Autowired UserService userService;
    
    @PostMapping("/api/auth/token")
    public ResponseEntity<String> authenticate(@RequestBody AuthRequest authRequest){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()
        ));
        if(authentication.isAuthenticated()){
            UserDetails user = userService.loadUserByUsername(authRequest.getUsername());
            return ResponseEntity.ok(jwtHelper.generateToken(user));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("unauthorized");
    }

}
