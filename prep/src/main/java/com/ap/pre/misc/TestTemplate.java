package com.ap.pre.misc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestTemplate {

@Autowired
private JdbcTemplate jdbcTemplate;

public void addUser(String name) {
    String sql = "INSERT INTO users (name) VALUES (?)";
    jdbcTemplate.update(sql, name);
}

}
