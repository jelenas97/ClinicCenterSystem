package com.clinicCenter.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserTokenState {

    private String accessToken;
    private Integer expiresIn;
    private String role;
    private Boolean passwordChanged;

    public UserTokenState(String jwt, int expiresIn, String role, Boolean passwordChanged) {
        this.accessToken = jwt;
        this.expiresIn = expiresIn;
        this.role = role;
        this.passwordChanged = passwordChanged;
    }

    public UserTokenState(Boolean passwordChanged){
        this.passwordChanged = passwordChanged;
    }
}
