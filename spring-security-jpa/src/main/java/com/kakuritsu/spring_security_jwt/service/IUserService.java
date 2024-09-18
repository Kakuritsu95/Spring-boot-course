package com.kakuritsu.spring_security_jwt.service;
import java.util.List;
import com.kakuritsu.spring_security_jwt.entities.User;
import org.springframework.stereotype.Component;

@Component
public interface IUserService {

    public User createUser(User user);

    public User findById(Long id);

    public List<User> findAll();
}
