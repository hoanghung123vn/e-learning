package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String CLASSNAME = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/learning_toeic_db?serverTimezone=UTC"
            + "&useUnicode=yes&characterEncoding=UTF-8";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";
    private static Connection connection;

    public static Connection getInstance() {
        try {
			if (connection == null || connection.isClosed()) {
				Class.forName(CLASSNAME);
			    connection = DriverManager.getConnection(URL, USER, PASSWORD);
			    System.out.println("Database connected");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
        return connection;
    }
}
