package com.genshin.genshinrolls.dto;

import lombok.Data;

@Data
public class SignUpRes {
    private int statusCode;
    private String error;
    private String message;
}
