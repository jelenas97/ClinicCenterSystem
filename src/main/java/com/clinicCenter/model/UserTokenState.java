package com.clinicCenter.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserTokenState {

    private String accessToken;
    private Integer expiresIn;

    public UserTokenState(String jwt, int expiresIn) {
    }
}
