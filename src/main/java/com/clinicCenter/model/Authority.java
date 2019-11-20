package com.clinicCenter.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Data
@Entity
public class Authority implements GrantedAuthority {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name")
    String name;

    @Override
    public String getAuthority() {
        return name;
    }


}
