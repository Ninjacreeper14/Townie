package com.ruinscraft.townie.classic.storage;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class SQLDatabase {

    public abstract Connection getConnection() throws SQLException;

    public abstract void createTables() throws SQLException;

}
