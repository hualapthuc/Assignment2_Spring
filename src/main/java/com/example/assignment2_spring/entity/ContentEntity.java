package com.example.assignment2_spring.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
@Entity
@Table(name = "content")
@Data
public class ContentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String brief;
    private String content;
    private Date createDate;
    private Date updateDate;
    private String sort;
    private String authorId;
}
