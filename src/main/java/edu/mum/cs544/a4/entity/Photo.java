package edu.mum.cs544.a4.entity;

import javax.persistence.*;

@Entity
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String path;

    public Long getId() {
        return id;
    }

    public String getPath() {
        return path;
    }
}
