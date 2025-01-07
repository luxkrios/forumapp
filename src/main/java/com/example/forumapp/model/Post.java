package com.example.forumapp.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "posts") 
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 5000)
    private String content;

    @Column(nullable = false)
    private String author;
}
