package jp.hashimoto_net;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HelloHSQLDB {

	
	// [todo] こういう定数は、プロパティファイルから取得するようにしましょう
	public static final String url = "jdbc:hsqldb:hsql://localhost/";
	public static final String username = "sa";
	static final String password= "";
	
	public HelloHSQLDB() throws ClassNotFoundException {
		String className = "org.hsqldb.jdbcDriver";
		Class.forName(className);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		HelloHSQLDB helloDb = new HelloHSQLDB();
		try {
			helloDb.showData();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return;
	}
	
	void showData() throws SQLException {
		String sql = "select * from customer";
		
		
		Connection conn = DriverManager.getConnection(url, username, password);
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		String delimiter = "|";
		
		while (rs.next()) {
			System.out.print(rs.getString("account_level") + delimiter);
			System.out.print(rs.getInt("age") + delimiter);
			System.out.print(rs.getString("sex") + delimiter);
			System.out.print(rs.getString("name") + delimiter);
			System.out.print(rs.getString("name_jp") + delimiter);
			System.out.print(rs.getString("job") + delimiter);
			System.out.print(rs.getString("company") + delimiter);
			System.out.print(rs.getString("company") + delimiter);
			System.out.print(rs.getString("dept") + delimiter);
			System.out.print(rs.getString("memo"));
			System.out.println("\n---------------------------------------");
		}
	}
}
