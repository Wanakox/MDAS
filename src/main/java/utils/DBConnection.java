package main.java.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection connection = null;

    public static Connection getConnection() throws SQLException {
        try {
            // Registrar manualmente el driver si aún no lo está
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("No se encontró el driver JDBC", e);
        }

        PropertyLoader propertyLoader = new PropertyLoader("/home/juan/Escritorio/MDAS/config.properties");

        if (connection == null || connection.isClosed()) {
            try {
                String url = propertyLoader.getProperty("db.url");
                String user = propertyLoader.getProperty("db.user");
                String password = propertyLoader.getProperty("db.password");

                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                e.printStackTrace();
                throw new SQLException("Error al conectar a la base de datos", e);
            }
        }

        return connection;
    }
}
