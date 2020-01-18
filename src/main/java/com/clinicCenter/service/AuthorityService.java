package com.clinicCenter.service;

import com.clinicCenter.model.Authority;

import java.util.List;

public interface AuthorityService {
    List<Authority> findById(Long id);
    List<Authority> findByName(String name);

}
