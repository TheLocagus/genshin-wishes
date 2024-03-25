package com.genshin.genshinrolls.service;

import com.genshin.genshinrolls.dto.*;
import com.genshin.genshinrolls.entity.Player.PlayerEntity;
import com.genshin.genshinrolls.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class AuthService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private JWTUtils jwtUtils;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    public SignUpRes signUp(SignUpReq registrationRequest){
        SignUpRes resp = new SignUpRes();
        try{
            PlayerEntity playerEntity = new PlayerEntity();
            playerEntity.setName(registrationRequest.getName());
            playerEntity.setEmail(registrationRequest.getEmail());
            playerEntity.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
            playerEntity.setRole(registrationRequest.getRole());
            PlayerEntity playerEntityResult = playerRepository.save(playerEntity);
            if(playerEntityResult != null && playerEntityResult.getId() > 0){
                resp.setMessage("User Saved Successfully: " + playerEntityResult.toString());
                resp.setStatusCode(200);
            }
        } catch (Exception e){
            resp.setStatusCode(500);
            resp.setError(e.getMessage());
        }
        return resp;
    }

    public SignInRes signIn(SignInReq signinRequest){
        SignInRes response = new SignInRes();

        try{
            authenticationManager
                    .authenticate
                            (
                                    new UsernamePasswordAuthenticationToken(
                                            signinRequest.getName(),
                                            signinRequest.getPassword()
                                    )
                            );
            var user = playerRepository.findByName(signinRequest.getName()).orElseThrow();
            var jwt = jwtUtils.generateToken(user);
            var refreshToken = jwtUtils.generateRefreshToken(new HashMap<>(), user);
            response.setStatusCode(200);
            response.setToken(jwt);
            response.setRefreshToken(refreshToken);
            response.setExpirationTime("24Hr");
            response.setMessage("Successfully Signed In");
            response.setRole(user.getRole());
        } catch(Exception e){
            response.setStatusCode(500);
            response.setError(e.getMessage());
        }
        return response;
    }

    public TokenRes refreshToken(TokenReq refreshTokenRequest){
        TokenRes response = new TokenRes();
        String name = jwtUtils.extractUsername(refreshTokenRequest.getToken());
        PlayerEntity users = playerRepository.findByName(name).orElseThrow();
        if(jwtUtils.isTokenValid(refreshTokenRequest.getToken(), users)){
            var jwt = jwtUtils.generateToken(users);
            response.setStatusCode(200);
            response.setToken(jwt);
            response.setRefreshToken(refreshTokenRequest.getToken());
            response.setExpirationTime("24Hr");
            response.setMessage("Successfully Refreshed Token");
            return response;
        }
        response.setStatusCode(500);
        return response;
    }
}
