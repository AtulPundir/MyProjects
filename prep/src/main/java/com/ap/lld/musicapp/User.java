package com.ap.lld.musicapp;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="users")
public class User {
    
    private Long id;

    private String name;

    private String email;

    private Subscription subscription;

    @OneToMany(mappedBy = "user")
    private List<Playlist> playlists;


}
