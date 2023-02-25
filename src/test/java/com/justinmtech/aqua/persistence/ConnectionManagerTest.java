package com.justinmtech.aqua.persistence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class ConnectionManagerTest {
    private Credentials credentials;
    private ConnectionManager connectionManager;

    @BeforeEach
    void setup() throws SQLException, ClassNotFoundException {
        credentials = new Credentials("server", "localhost", "root", "password", 3306);
        connectionManager = new ConnectionManager(credentials, 10, "com.mysql.cj.jdbc.Driver");
    }

    @Test
    void getPoolSize() {
    }

    @Test
    void getDataSourceClassName() {
    }

    @Test
    void getDataSource() {
    }

    @Test
    void getConnection() {
    }
}