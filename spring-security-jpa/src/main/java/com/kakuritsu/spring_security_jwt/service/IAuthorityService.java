package com.kakuritsu.spring_security_jwt.service;

import com.kakuritsu.spring_security_jwt.entities.Authority;
import com.kakuritsu.spring_security_jwt.entities.User;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface IAuthorityService {

    public Authority createAuthority(Authority authority);

    public Authority findById(Long id);

    public List<Authority> findAll();
}