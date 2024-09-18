package com.kakuritsu.spring_security_jwt.UserMapper;

import com.kakuritsu.spring_security_jwt.dto.UserDTO;
import com.kakuritsu.spring_security_jwt.entities.User;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class UserMapper {
//    public static UserDTO toDTO(User user) {
//        List<String> roleNames = user.getRoles().stream()
//                .map(role -> role.getAuthority().getRole())
//                .collect(Collectors.toList());
//
//        return new UserDTO(
//                user.getId(),
//                user.getUsername(),
//                user.getCountry(),
//                roleNames
//        );
//    }
//}

