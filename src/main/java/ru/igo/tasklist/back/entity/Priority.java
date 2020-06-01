package ru.igo.tasklist.back.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@Table(name = "priority", schema = "tasklist")
public class Priority {
    private Long id;
    private String title;
    private String color;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    @Basic
    @Column(name = "title", length = 45)
    public String getTitle() {
        return title;
    }

    @Basic
    @Column(name = "color", length = 45)
    public String getColor() {
        return color;
    }
}
