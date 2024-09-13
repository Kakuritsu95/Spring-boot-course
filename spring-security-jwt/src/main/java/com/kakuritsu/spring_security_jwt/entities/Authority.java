package com.kakuritsu.spring_security_jwt.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;


@Entity
@Table(name = "authorities")
public class Authority {
    Authority(){};

    public Authority(String role, List<User> users) {
        this.role = role;
//        this.users = users;
    }

    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="authority_id")
Long id;

@Column(name = "authority_name")
String role;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

//    public List<User> getUsers() {
//        return users;
//    }
//
//    public void setUsers(List<User> users) {
//        this.users = users;
//    }
}