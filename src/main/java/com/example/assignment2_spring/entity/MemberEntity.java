package com.example.assignment2_spring.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "username", nullable = false, length = 200)
    private String userName;
    @Column(name = "password", nullable = false, length = 200)
    private String password;
    @Column(name = "firstname", nullable = false, length = 20)
    private String firstName;
    @Column(name = "lastname", nullable = false, length = 20)
    private String lastName;
    @Column(name = "description", length = 200)
    private String description;
    @Column(name = "phone", nullable = false, length = 20)
    private String phone;
    @Column(name = "email", nullable = false, length = 50)
    private String email;
    @Column(name = "createDate", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createDate;
    @Column(name = "updatedDate", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Date updateDate;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "memberEntity")
    private List<ContentEntity> contentEntityList;
}
