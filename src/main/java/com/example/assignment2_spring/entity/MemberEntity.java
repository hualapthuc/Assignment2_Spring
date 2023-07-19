package com.example.assignment2_spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "member")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "username", nullable = false, length = 200, unique = true)
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
    @Column(name = "email", nullable = false, length = 50, unique = true)
    private String email;

    @CreationTimestamp
    @Column(name = "created_date", nullable = false, updatable = false)
    private Timestamp createdDate;

    @UpdateTimestamp
    @Column(name = "updated_date", nullable = false)
    private Timestamp updatedDate;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "memberEntity")
    private List<ContentEntity> contentEntityList;
}
