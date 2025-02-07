package com.ap.lld.musicapp;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="albums")
public class Album {

    private Long id;

    private UUID riderId;

    private String name;

    private Artist artist;

}
