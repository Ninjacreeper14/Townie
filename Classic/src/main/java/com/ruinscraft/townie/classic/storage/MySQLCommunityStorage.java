package com.ruinscraft.townie.classic.storage;

import com.ruinscraft.townie.api.community.ICommunity;
import com.ruinscraft.townie.api.storage.ICommunityStorage;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.CompletableFuture;

public class MySQLCommunityStorage extends MySQLDatabase implements ICommunityStorage {

    public MySQLCommunityStorage(String hostname, int port, String database, String username, String password) {
        super(hostname, port, database, username, password);
    }

    @Override
    public CompletableFuture<Void> save(ICommunity iCommunity) {
        return CompletableFuture.runAsync(() -> {
            try (Connection connection = getConnection()) {

            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public CompletableFuture<ICommunity> load(int id) {
        return CompletableFuture.supplyAsync(() -> {
            try (Connection connection = getConnection()) {

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return null;
        });
    }

    @Override
    public void createTables() throws SQLException {
        try (Connection connection = getConnection()) {
            try (Statement statement = connection.createStatement()) {
                statement.execute("CREATE TABLE IF NOT EXISTS townie_communities (" +
                        "id INT NOT NULL AUTO_INCREMENT, " +
                        "name VARCHAR(32) NOT NULL, " +
                        "board TEXT, " +
                        "created_at BIGINT, " +
                        "public BOOL, " +
                        "open BOOL, " +
                        "spawn_location_id INT, " +
                        "FOREIGN KEY (spawn_location_id) REFERENCES townie_locations (id), " +
                        "PRIMARY KEY (id));");
            }
        }
    }

}
