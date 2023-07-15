package com.example.assignment2_spring.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "content")
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
    @Column(name = "createdDate", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "updatedDate", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

    private String sort;
    @ManyToOne
    @JoinColumn(name = "authorId")
    private MemberEntity memberEntity;
}
