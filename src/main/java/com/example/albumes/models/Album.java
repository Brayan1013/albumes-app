package com.example.albumes.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ALBUM")
public class Album {

    @Id
    private String id;
    @Column(name = "NAME_ALBUM")
    private String name;
    @Column(name = "LINK_PICTURE")
    private String linkPicture;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ARTIST_ID", nullable = false)
    @JsonBackReference
    private Artist artist;
}
