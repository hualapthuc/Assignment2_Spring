package com.example.assignment2_spring.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "member")
@Data
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String description;
    private String phone;
    private String email;
}
