package com.genshin.genshinrolls.controllers;


import com.genshin.genshinrolls.dto.*;
import com.genshin.genshinrolls.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<SignUpRes> signUp(@RequestBody SignUpReq signUpRequest){
        return ResponseEntity.ok(authService.signUp(signUpRequest));
    }

    @PostMapping("/signin")
    public ResponseEntity<SignInRes> signIn(@RequestBody SignInReq signInRequest){
        return ResponseEntity.ok(authService.signIn(signInRequest));
    }

    @PostMapping("/refresh")
    public ResponseEntity<TokenRes> refreshToken(@RequestBody TokenReq refreshTokenRequest){
        return ResponseEntity.ok(authService.refreshToken(refreshTokenRequest));
    }
}