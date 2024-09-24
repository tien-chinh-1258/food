package vn.herta.configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import vn.herta.models.UserModel;


public class DBConnectMySQL {

	private static String USERNAME = "root";
	private static String PASSWORD = "125252";
	private static String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static String URL = "jdbc:mysql://localhost:3306/LTW";

	public static Connection getDatabaseConnection() throws SQLException, Exception {

		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		try {
			new DBConnectMySQL();
			System.out.println(DBConnectMySQL.getDatabaseConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<UserModel> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
