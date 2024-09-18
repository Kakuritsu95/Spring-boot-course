package com.kakuritsu.spring_security_jwt.service;

import com.kakuritsu.spring_security_jwt.dao.UserDao;
import com.kakuritsu.spring_security_jwt.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;  // Import the List interface from java.util
@Service
public class UserService implements IUserService {
    private final UserDao userDao;
UserService(UserDao userDao){
    this.userDao = userDao;
}
    @Override
    public User createUser(User user) {
      return userDao.save(user);
    }

    @Override
    public User findById(Long id) {
       return userDao.findById(id).orElseThrow(()->  new RuntimeException("Not Found"));
    }

    @Override
    public List<User> findAll() {
       return userDao.findAll();
    }
}