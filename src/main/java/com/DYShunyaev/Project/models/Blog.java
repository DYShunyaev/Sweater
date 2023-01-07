package com.DYShunyaev.Project.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.relational.core.mapping.Column;

@Entity
@Data
@AllArgsConstructor
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    @Column
    String blogName;

    @Column
    String blogText;

    public Blog() {
    }

    public Blog(String blogName, String blogText) {
        this.blogName = blogName;
        this.blogText = blogText;
    }
}
