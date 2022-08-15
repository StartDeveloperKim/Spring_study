package com.spring.study.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterDTO {

    private String id; // PK
    private String password;
    private String confirmPassword;
    private String name;
    private String nickname;

    public boolean isEqualPasswordConfirmPassword() {
        return password.equals(confirmPassword);
    }
}
