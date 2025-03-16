package com.kusl.randomGeneratorBE.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "tags")
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class Tags {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(unique = true)
    String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "quote_tags",
            joinColumns = @JoinColumn(name = "tag_id"),
            inverseJoinColumns = @JoinColumn(name = "quote_id")
    )
    Set<Quote> quotes = new HashSet<>();

    public Tags() {

    }
}
