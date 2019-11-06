package com.clinicCenter.model;

import lombok.Builder;
import lombok.Data;

import java.util.Collection;

@Data
@Builder
public class Role {
    private Long id;
    private String name;
    private Collection<User> users;
}
