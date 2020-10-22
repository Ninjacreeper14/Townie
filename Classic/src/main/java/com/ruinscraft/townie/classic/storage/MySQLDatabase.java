package com.ruinscraft.townie.classic.storage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class MySQLDatabase extends SQLDatabase {

    private final String hostname;
    private final int port;
    private final String database;
    private final String username;
    private final String password;

    public MySQLDatabase(String hostname, int port, String database, String username, String password) {
        this.hostname = hostname;
        this.port = port;
        this.database = database;
        this.username = username;
        this.password = password;

        try {
            createTables();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        String jdbcUrl = "jdbc:mysql://" + hostname + ":" + port + "/" + database;
        return DriverManager.getConnection(jdbcUrl, username, password);
    }

}
