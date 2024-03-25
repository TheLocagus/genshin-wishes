package com.genshin.genshinrolls.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SignInRes {
    private String token;
    private String refreshToken;
    private int statusCode;
    private String error;
    private String message;
    private String expirationTime;
    private String role;
}
