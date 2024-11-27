package vn.herta.configs;

import java.sql.Connection;
import java.sql.DriverManager;



public class DBConnectSQL {

	private final String serverName = "localhost";
	private final String dbName = "LTW";
	private final String portNumber = "1433";
	private final String instance="";
	private final String userID="sa";
	private final String password="125252";

	public Connection getConnection() throws Exception{
		
	
			String url = "jdbc:sqlserver://"+serverName+":"+portNumber + "\\"+instance+";databaseName="+dbName;
			if(instance == null || instance.trim().isEmpty())
				
				url="jdbc:sqlserver://"+serverName+":"+portNumber+";databaseName="+dbName;
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			return DriverManager.getConnection(url,userID,password);
			
		
	}
	public static void main(String[] args) {
		try {
			System.out.println(new DBConnectSQL().getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
