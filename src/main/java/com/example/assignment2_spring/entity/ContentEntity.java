package com.example.assignment2_spring.entity;
import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Table(name = "content_entity")
@Data
public class ContentEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "title", nullable = false, length = 500)
    private String title;
    @Column(name = "brief", nullable = false, length = 500)
    private String brief;
    @Column(name = "content", nullable = false, length = 5000)
    private String content;

    @Column(name = "createdDate", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @Column(name = "updatedDate", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

    private String sort;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private MemberEntity memberEntity;
}
