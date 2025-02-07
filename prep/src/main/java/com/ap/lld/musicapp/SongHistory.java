package com.ap.lld.musicapp;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "playback_history")
public class SongHistory {

    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Song song;

    LocalDateTime playedAt;

}
