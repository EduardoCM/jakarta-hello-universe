package org.tesji.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class Db {

	public static Connection get() throws Exception {
        return DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/tesji",
            "postgres",
            "sasa"
        );
    }
}
