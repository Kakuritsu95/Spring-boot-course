package com.kakuritsu.spring_security_jwt.service;

import com.kakuritsu.spring_security_jwt.entities.Authority;
import com.kakuritsu.spring_security_jwt.dao.AuthorityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthorityService implements IAuthorityService{

        private final AuthorityDao authorityDao;
        @Autowired
    AuthorityService(AuthorityDao authorityDao){
            this.authorityDao= authorityDao;
        }
        @Override
        public Authority createAuthority(Authority authority) {
            return authorityDao.save(authority);
        }

        @Override
        public Authority findById(Long id) {
            return authorityDao.findById(id).orElseThrow(()->  new RuntimeException("Not Found"));
        }

        @Override
        public List<Authority> findAll() {
            return authorityDao.findAll();
        }
    }

