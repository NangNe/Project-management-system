package cuoiky;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConnectionDB {
	static Connection conn;
	static Statement stm;

	public Statement getStm() {
		return stm;
	}

	public static void setStm(Statement stm) {
		ConnectionDB.stm = stm;
	}

	private static String DB_URL = "jdbc:sqlserver://localhost;user=sa;password=123456t;database=qlproject;";

	public ConnectionDB() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(DB_URL, "sa", "123456t");
			//System.out.println("Successful!");
			stm = conn.createStatement();
		} catch (Exception ex) {
			System.out.println("Fail!");
			ex.printStackTrace();
		}
	}

	public static Connection getConn() {
		return conn;
	}

	public static void setConn(Connection conn) {
		ConnectionDB.conn = conn;
	}

	public static void main(String[] args) {
		new ConnectionDB();

	}
}
