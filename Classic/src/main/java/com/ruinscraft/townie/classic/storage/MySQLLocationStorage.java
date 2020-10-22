package com.ruinscraft.townie.classic.storage;

import com.ruinscraft.townie.api.ILocation;
import com.ruinscraft.townie.api.storage.ILocationStorage;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.CompletableFuture;

public class MySQLLocationStorage extends MySQLDatabase implements ILocationStorage {

    public MySQLLocationStorage(String hostname, int port, String database, String username, String password) {
        super(hostname, port, database, username, password);
    }

    @Override
    public CompletableFuture<Void> save(ILocation iLocation) {
        return CompletableFuture.runAsync(() -> {

        });
    }

    @Override
    public CompletableFuture<ILocation> load(int id) {
        return CompletableFuture.supplyAsync(() -> {
            return null;
        });
    }

    @Override
    public void createTables() throws SQLException {
        try (Connection connection = getConnection()) {
            try (Statement statement = connection.createStatement()) {
                statement.execute("CREATE TABLE IF NOT EXISTS townie_locations (" +
                        "id INT NOT NULL AUTO_INCREMENT, " +
                        "world_name VARCHAR(64) NOT NULL, " +
                        "x FLOAT, " +
                        "y FLOAT, " +
                        "z FLOAT, " +
                        "yaw FLOAT, " +
                        "pitch FLOAT, " +
                        "PRIMARY KEY (id));");
            }
        }
    }

}
