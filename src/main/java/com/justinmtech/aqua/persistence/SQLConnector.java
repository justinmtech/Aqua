package com.justinmtech.aqua.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnector {
    private final String database;
    private final String host;
    private final String username;
    private final String password;
    private final int port;

    public SQLConnector(String database, String host, String username, String password, int port) throws SQLException {
        if (database == null) throw new SQLException("The database is null.");
        if (host == null) throw new SQLException("The host is null.");
        if (username == null) throw new SQLException("The username is null.");
        if (password == null) throw new SQLException("The password is null.");
        if (port == 0) throw new SQLException("The port is invalid.");
        this.database = database;
        this.host = host;
        this.username = username;
        this.password = password;
        this.port = port;
    }

    //Get MySQL connection with auto reconnect and no SSL
    public Connection getMySQLConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database + " ?autoReconnect=true&useSSL=false", username, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("Could not get MySQL connection! Please check the database settings.");
        }
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
