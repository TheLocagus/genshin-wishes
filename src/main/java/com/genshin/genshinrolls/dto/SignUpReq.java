package com.genshin.genshinrolls.dto;

import lombok.Data;

@Data
public class SignUpReq {
    private String name;
    private String password;
    private String email;
    private String role;
}
