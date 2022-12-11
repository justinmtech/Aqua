package com.justinmtech.aqua.persistence;


/**
 *Useful if you forget simple query syntax and want to avoid googling
 * Replace "equals" with =
 * Parameters are always wrapped with ()'s

 * Example Queries
 * CREATE TABLE IF NOT EXISTS myTable(uuid VARCHAR(48) NOT NULL PRIMARY KEY, level INT NOT NULL DEFAULT 0);
 * INSERT INTO myTable VALUES (?, ?);
 * DELETE FROM myTable WHERE uuid = ?;
 * UPDATE myTable SET (uuid, level) VALUES (?, ?)
 * SELECT uuid, level FROM myTable WHERE uuid = ?;
 **/
public enum SQLQueries {
    CREATE_TABLE_tableName_parameters,
    CREATE_TABLE_IF_NOT_EXISTS_tableName_parameters,
    INSERT_INTO_tableName_VALUES_parameters,
    DELETE_FROM_tableName_WHERE_column_equals_value,
    UPDATE_TABLE_tableName_SET_column_equals_value,
    SELECT_columns_FROM_tableName_WHERE_uuid_equals_value,
    }
