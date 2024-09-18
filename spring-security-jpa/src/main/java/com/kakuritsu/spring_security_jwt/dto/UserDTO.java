package com.kakuritsu.spring_security_jwt.dto;

import java.util.List;

public class UserDTO {
    private Long id;

    private String username;

    private String country;
    private List<String> roles;

    // Constructor
    public UserDTO(Long id, String username,  String country, List<String> roles) {
        this.id = id;
        this.username = username;
        this.country = country;
        this.roles = roles;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }




    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", country='" + country + '\'' +
                ", roles=" + roles +
                '}';
    }
}

