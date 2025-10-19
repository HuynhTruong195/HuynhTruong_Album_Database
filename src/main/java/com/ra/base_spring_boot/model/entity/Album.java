package com.ra.base_spring_boot.model.entity;

import com.ra.base_spring_boot.model.constants.TypeAlbum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "release_date")
    private LocalDateTime releaseDate;

    @Column(name = "cover_image")
    private String coverImage;

    @Column(name = "type")
    private TypeAlbum type;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "artist_id")
    private Artist artist;

    @PrePersist
    public void prePersist()
    {
        this.createdAt = LocalDateTime.now();
    }
    @PreUpdate
    public void preUpdate()
    {
        this.updatedAt = LocalDateTime.now();
    }
}
