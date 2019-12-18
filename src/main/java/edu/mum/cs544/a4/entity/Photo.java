package edu.mum.cs544.a4.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String path;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "id=" + id +
                ", path='" + path + '\'' +
                '}';
    }

    public void setPath(String path) {
        this.path = path;
    }
}
