package com.ap.lld.musicapp;

import java.util.List;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

public class Playlist {

    private Long id;

    private List<Song> songs;

    @OneToOne(mappedBy = "user")
    private User user;

}
