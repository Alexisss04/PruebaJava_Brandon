package com.bandesal.pruebajava_brandon.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "READERS")
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "readers_seq")
    @SequenceGenerator(name = "readers_seq", sequenceName = "READERS_SEQ", allocationSize = 1)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 8, message = "El nombre no puede exceder 8 caracteres")
    @Column(name = "NAME", length = 8, nullable = false)
    private String name;

    @ManyToMany(mappedBy = "readers")
    private Set<Blog> blogs = new HashSet<>();

    public Reader() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Set<Blog> getBlogs() { return blogs; }
    public void setBlogs(Set<Blog> blogs) { this.blogs = blogs; }
}