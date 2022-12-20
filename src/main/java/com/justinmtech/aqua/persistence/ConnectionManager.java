package com.justinmtech.aqua.persistence;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.jetbrains.annotations.NotNull;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Uses HikariCP to obtain a DataSource.
 */
public class ConnectionManager {
    private final int poolSize;
    private final String dataSourceClassName;
    private final DataSource dataSource;

    private final static int DEFAULT_POOL_SIZE = 10;

    /**
     *Initialize the ConnectionManager and attempt to initialize data source.
     *MySQL Class Name: com.mysql.cj.jdbc.MysqlDataSource
     *MariaDB Class Name: org.mariadb.jdbc.MariaDbDataSource
     * @param credentials The database user credentials
     * @param poolSize The size of the pool
     * @param dataSourceClassName The class name of the data source
     */
    public ConnectionManager(@NotNull Credentials credentials, int poolSize, @NotNull String dataSourceClassName) {
        this.poolSize = poolSize;
        this.dataSourceClassName = dataSourceClassName;
        this.dataSource = initDataSource(credentials);
    }

    /**
     * @param credentials Database credentials
     * @return HikariDataSource
     */
    private DataSource initDataSource(@NotNull Credentials credentials) {
        Properties properties = new Properties();
        properties.setProperty("dataSourceClassName", getDataSourceClassName());
        properties.setProperty("dataSource.serverName", credentials.getHost());
        properties.setProperty("dataSource.portNumber", String.valueOf(credentials.getPort()));
        properties.setProperty("dataSource.user", credentials.getUsername());
        properties.setProperty("dataSource.password", credentials.getPassword());
        properties.setProperty("dataSource.databaseName", credentials.getDatabase());

        HikariConfig config = new HikariConfig(properties);
        config.setMaximumPoolSize(getPoolSize());

        return new HikariDataSource(config);
    }

    /**
     * @return The pool size. Returns DEFAULT_POOL_SIZE if less than 1.
     */
    public int getPoolSize() {
        if (poolSize > 1) {
            return poolSize;
        } else {
            return DEFAULT_POOL_SIZE;
        }
    }

    public String getDataSourceClassName() {
        return dataSourceClassName;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    /**
     * @return Connection
     * @throws SQLException Throw an SQLException if connection error
     */
    public Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }
}
