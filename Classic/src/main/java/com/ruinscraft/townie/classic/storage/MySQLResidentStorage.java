package com.ruinscraft.townie.classic.storage;

import com.ruinscraft.townie.api.IResident;
import com.ruinscraft.townie.api.storage.IResidentStorage;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.CompletableFuture;

public class MySQLResidentStorage extends MySQLDatabase implements IResidentStorage {

    public MySQLResidentStorage(String hostname, int port, String database, String username, String password) {
        super(hostname, port, database, username, password);
    }

    @Override
    public CompletableFuture<Void> save(IResident iResident) {
        return CompletableFuture.runAsync(() -> {
            try (Connection connection = getConnection()) {

            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public CompletableFuture<IResident> load(int id) {
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
                statement.execute("CREATE TABLE IF NOT EXISTS townie_residents (" +
                        "id INT NOT NULL AUTO_INCREMENT, " +
                        "uuid VARCHAR(36) NOT NULL, " +
                        "username VARCHAR(16), " +
                        "first_seen BIGINT, " +
                        "last_seen BIGINT, " +
                        "UNIQUE (uuid), " +
                        "PRIMARY KEY (id));");
                statement.execute("CREATE TABLE IF NOT EXISTS townie_resident_roles (" +
                        "resident_id INT NOT NULL, " +
                        "role_id INT NOT NULL, " +
                        "FOREIGN KEY (resident_id) REFERENCES townie_residents (id), " +
                        "FOREIGN KEY (role_id) REFERENCES townie_roles (id));");
            }
        }
    }

}
