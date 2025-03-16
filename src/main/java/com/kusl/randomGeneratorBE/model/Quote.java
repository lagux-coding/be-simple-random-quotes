package com.kusl.randomGeneratorBE.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "quotes")
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class Quote {

    @Id
    @Column(name = "quote_id", columnDefinition = "uuid")
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    String content;

    String author;

    //tags
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "quote_tags",
            joinColumns = @JoinColumn(name = "quote_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    Set<Tags> tags = new HashSet<>();

    public Quote() {

    }
}
