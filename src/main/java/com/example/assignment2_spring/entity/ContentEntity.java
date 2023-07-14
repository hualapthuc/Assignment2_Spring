package com.example.assignment2_spring.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
@Entity
@Data
public class ContentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "title", nullable = false, length = 200)
    private String title;
    @Column(name = "brief", nullable = false, length = 200)
    private String brief;
    @Column(name = "content", nullable = false, length = 200)
    private String content;
    @Column(name = "createDate", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createDate;
    @Column(name = "updatedDate", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Date updateDate;
    @Column(name = "sort", nullable = false, length = 200)
    private String sort;
    @ManyToOne
    @JoinColumn(name = "authorId")
    private MemberEntity memberEntity;
}
