package com.ra.base_spring_boot.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "artist_name")
    private String artistName;

    @Column(name = "artist_bio")
    private String artistBio; //chú thích tiểu sử của nghệ sĩ

    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Album> albums;
    //Cascade: thao tác thêm sửa xóa artist thì album cũng bị tác động, vd xóa Artist thì Album cũng bị xóa
    //orphanRemoval: nếu Album bị xóa khỏi artist mà không liên kết vs Artist khác thì sẽ bị xóa khỏi DB
}
