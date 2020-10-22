package com.ruinscraft.townie.classic.storage;

import com.ruinscraft.townie.api.IRole;
import com.ruinscraft.townie.api.storage.IRoleStorage;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.CompletableFuture;

public class MySQLRoleStorage extends MySQLDatabase implements IRoleStorage {

    public MySQLRoleStorage(String hostname, int port, String database, String username, String password) {
        super(hostname, port, database, username, password);
    }

    @Override
    public CompletableFuture<Void> save(IRole role) {
        return CompletableFuture.runAsync(() -> {
            try (Connection connection = getConnection()) {

            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public CompletableFuture<IRole> load(int id) {
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
                statement.execute("CREATE TABLE IF NOT EXISTS townie_roles (id INT NOT NULL AUTO_INCREMENT, name VARCHAR(32), PRIMARY KEY (id));");
            }
        }
    }

}
