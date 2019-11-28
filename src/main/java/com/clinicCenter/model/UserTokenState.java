package com.clinicCenter.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserTokenState {

    private String accessToken;
    private Integer expiresIn;
    private String role;

    public UserTokenState(String jwt, int expiresIn, String role) {
        this.accessToken = jwt;
        this.expiresIn = expiresIn;
        this.role = role;
    }
}
