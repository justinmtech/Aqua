package com.justinmtech.aqua.persistence;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class CredentialsTest {
    private Credentials credentials;

    @BeforeEach
    void setup() throws SQLException {
        credentials = new Credentials("server", "localhost", "root", "password", 3306);
    }

    @Test
    void getDatabase() {
        Assertions.assertEquals("server", credentials.getDatabase());
    }

    @Test
    void getHost() {
        Assertions.assertEquals("localhost", credentials.getHost());
    }

    @Test
    void getUsername() {
        Assertions.assertEquals("root", credentials.getUsername());
    }

    @Test
    void getPassword() {
        Assertions.assertEquals("password", credentials.getPassword());
    }

    @Test
    void getPort() {
        Assertions.assertEquals(3306, credentials.getPort());
    }
}