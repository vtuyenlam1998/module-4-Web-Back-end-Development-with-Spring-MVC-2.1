package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "image",length = 1000, nullable = false)
    private String image;
    @Column(name = "title",length = 100, nullable = false)
    private String title;
    @Column(name = "summary",length = 500, nullable = false)
    private String summary;
    @Column(name = "detail",length = 3000, nullable = false)
    private String detail;
    private LocalDateTime datePost;

}
