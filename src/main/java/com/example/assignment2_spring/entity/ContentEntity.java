package com.example.assignment2_spring.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;
@Entity
@Data
public class Content {
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
