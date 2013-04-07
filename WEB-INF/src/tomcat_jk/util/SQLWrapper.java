package tomcat_jk.util;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLWrapper {

	private static Connection conn;
	private static SQLWrapper sqlWrapper;
	
	private PreparedStatement pStmt;
	
	private ResultSet rs;
	
	private Statement stmt;
	
	private PropertyReader propReader;
	
	private String url;
	private String id;
	private String pwd;
	
	private static String filePath;
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	protected void getProps(String filename) throws IOException {
		propReader = new PropertyReader();
		
		System.out.println("filePath = " + filePath);
		System.out.println("filename = " + filename);
		propReader.loadFromXML(filename);
//		propReader.loadFromXML("C:\\java\\properties.xml");
		url = propReader.getProperty("dbUrl");
		id = propReader.getProperty("dbId");
		pwd = propReader.getProperty("dbPwd");
	}
	
	protected void getProps() throws IOException {
		propReader = new PropertyReader();
		
		System.out.println("filePath = " + filePath);
		propReader.loadFromXML(this.filePath);
		url = propReader.getProperty("dbUrl");
		id = propReader.getProperty("dbId");
		pwd = propReader.getProperty("dbPwd");
	}

	/** プライベートスコープのコンストラクタ */
	private SQLWrapper() throws ClassNotFoundException {
		Class.forName("org.hsqldb.jdbcDriver");
	}
	
	public static synchronized SQLWrapper getInstance()
			throws ClassNotFoundException {
		if (sqlWrapper == null) {
			sqlWrapper = new SQLWrapper();
		}
		return sqlWrapper;
	}
	
	public void getConnection(String url,
				String id,
				String pwd) 
		throws SQLException {
	this.conn = DriverManager.getConnection(url, id, pwd);
	}

	public void getConnection(String fileName) throws SQLException, IOException {
		getProps(fileName);
		this.conn = DriverManager.getConnection(this.url, this.id, this.pwd);
	}

	public PreparedStatement prepareStatement(String sql)
			throws SQLException {
		pStmt = this.conn.prepareStatement(sql);
		return pStmt;
	}
	
	public void setString(int index, String param) throws SQLException {
		pStmt.setString(index, param);
	}

	public ResultSet executeQuery() throws SQLException {
		ResultSet rs = pStmt.executeQuery();
		return rs;
	}
	
	public void close() throws SQLException {
		if (this.rs != null) this.rs.close();
		if (this.pStmt != null) this.pStmt.close();
		if (this.conn != null) this.conn.close();
	}
	
}
