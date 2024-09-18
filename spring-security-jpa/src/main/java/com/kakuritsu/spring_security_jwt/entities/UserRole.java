//package com.kakuritsu.spring_security_jwt.entities;
//
//
//import com.fasterxml.jackson.annotation.JsonBackReference;
//import jakarta.persistence.*;
//
//import java.util.Set;
//
//
//@Entity
//@Table(name = "roles")
//public class UserRole {
//    UserRole(){};
//
//    public UserRole(User user, Authority authority) {
//        this.user = user;
//        this.authority = authority;
//    }
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    Long id;
//    @ManyToOne
//    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
//  @JsonBackReference
//   User user;
//    @ManyToOne
//    @JoinColumn(name = "authority_id", referencedColumnName = "authority_id")
//    Authority authority;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public Authority getAuthority() {
//        return authority;
//    }
//
//    public void setAuthority(Authority authority) {
//        this.authority = authority;
//    }
//}
