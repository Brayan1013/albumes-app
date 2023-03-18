package com.example.albumes.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "ARTIST")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Artist {
    @Id
    @Column(name = "ID")
    private String id;
    @Column(name = "NAME_ARTIST")
    private String nameArtist;
    @Column(name = "CREATION_DATE")
    private Date creationDate;
    @Column(name = "COUNTRY")
    private String country;
    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Album> albums = new ArrayList<>();


}
