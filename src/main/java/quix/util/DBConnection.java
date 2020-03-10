package quix.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private static Connection CONNECTION;

	private static String dbDriver = "jdbc:sqlserver";
	private static String dbServer = "localhost";
	private static String dbPort = "1433";
	private static String dbDatabase = "Quiz";
	private static String dbUsername = "admin";
	private static String dbPassword = "admin";

	public static Connection getConnection() {
		if (CONNECTION != null) {
			return CONNECTION;
		}

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			StringBuilder stringBuilder = new StringBuilder();

			stringBuilder.append(dbDriver);
			stringBuilder.append("://");
			stringBuilder.append(dbServer);
			stringBuilder.append(":");
			stringBuilder.append(dbPort);
			stringBuilder.append(";database=");
			stringBuilder.append(dbDatabase);
			stringBuilder.append(";user=");
			stringBuilder.append(dbUsername);
			stringBuilder.append(";password=");
			stringBuilder.append(dbPassword);

			CONNECTION = (Connection) DriverManager.getConnection(stringBuilder.toString());
			CONNECTION.setAutoCommit(false);
			
			System.out.println("Connect to Database Successfully!");

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		return CONNECTION;
	}

	public static void closeConnection() {
		if (CONNECTION != null) {
			try {
				CONNECTION.close();
				CONNECTION = null;
				System.out.println("Disconnect to Database !");
				System.out.println();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
