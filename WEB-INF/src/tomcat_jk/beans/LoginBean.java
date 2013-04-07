package tomcat_jk.beans;

import java.io.IOException;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;

import tomcat_jk.dao.SearchDAO;
import tomcat_jk.util.PropertyReader;
import tomcat_jk.util.SQLWrapper;

public class LoginBean implements Serializable {

	static SearchDAO dao = new SearchDAO();

	public static String getAccountLevel( String id, String pwd, String path ) 
			throws SQLException, 
			       ClassNotFoundException,
			       IOException {
		PropertyReader propReader = new PropertyReader();
		propReader.loadFromXML(path);
		String dbUrl = propReader.getProperty("dbUrl");
		String sqlStatement = propReader.getProperty("statement_1");
		
		SQLWrapper sql = SQLWrapper.getInstance();
		sql.setFilePath(path);
		//sql.getConnection();
		sql.prepareStatement(sqlStatement);
		sql.setString(1, id);
		sql.setString(2, pwd);
		ResultSet rs = sql.executeQuery();
		String level = "";
		if (rs.next()) {
			level = rs.getString("web_account_level");
		} else {
			level = "";
		}
		
		return level;
	}
	
} // end of class.
