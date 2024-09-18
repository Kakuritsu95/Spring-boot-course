package com.kakuritsu.spring_security_jwt.dao;

import com.kakuritsu.spring_security_jwt.entities.Authority;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AuthorityDao extends JpaRepository<Authority,Long> {
}
