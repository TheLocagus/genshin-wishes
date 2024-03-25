package com.genshin.genshinrolls.dto;

import lombok.Data;

@Data
public class TokenRes {
    private int statusCode;
    private String message;
    private String error;
    private String token;
    private String refreshToken;
    private String expirationTime;
}
