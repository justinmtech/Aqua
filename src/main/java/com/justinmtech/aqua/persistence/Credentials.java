package com.justinmtech.aqua.persistence;

import org.jetbrains.annotations.Nullable;

import java.sql.SQLException;

/**
 *Store database credential information
 */
public class Credentials {
    private final String database;
    private final String host;
    private final String username;
    private final String password;
    private final int port;

    /**
     * @param database Database name
     * @param host IP address of SQL server
     * @param username Username of SQL server
     * @param password Password of SQL server
     * @param port Port of SQL server
     * @throws SQLException Throw SQLException if encountered
     */
    public Credentials(@Nullable String database,
                       @Nullable String host,
                       @Nullable String username,
                       @Nullable String password,
                       int port) throws SQLException {

        if (database == null) throw new SQLException("The database is null.");
        if (host == null) throw new SQLException("The host is null.");
        if (username == null) throw new SQLException("The username is null.");
        if (password == null) throw new SQLException("The password is null.");
        if (port < 1) throw new SQLException("The port is invalid.");
        this.database = database;
        this.host = host;
        this.username = username;
        this.password = password;
        this.port = port;
    }

    public String getDatabase() {
        return database;
    }

    public String getHost() {
        return host;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getPort() {
        return port;
    }

}
