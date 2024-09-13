package com.kakuritsu.spring_security_jwt.dao;

import com.kakuritsu.spring_security_jwt.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserDao extends JpaRepository<User,Long> {
}
