package com.bandesal.pruebajava_brandon.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "BLOGS")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "blogs_seq")
    @SequenceGenerator(name = "blogs_seq", sequenceName = "BLOGS_SEQ", allocationSize = 1)
    private Long id;

    @NotBlank(message = "El título es obligatorio")
    @Size(max = 50, message = "El título no puede exceder 50 caracteres")
    @Column(name = "TITLE", length = 50, nullable = false)
    private String title;

    @Size(max = 4000, message = "La descripción no puede exceder 4000 caracteres")
    @Column(name = "DESCRIPTION", length = 4000)
    private String description;

    @ManyToMany
    @JoinTable(
            name = "BLOGS_READERS",
            joinColumns = @JoinColumn(name = "B_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "R_ID", referencedColumnName = "ID")
    )
    private Set<Reader> readers = new HashSet<>();

    public Blog() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Set<Reader> getReaders() { return readers; }
    public void setReaders(Set<Reader> readers) { this.readers = readers; }
}