import java.io.IOException;
import java.sql.SQLException;

import tomcat_jk.beans.LoginBean;

public class TestDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
			throws SQLException, 
					IOException,
					ClassNotFoundException
					{
		String level = "";
		String path = "C:\\eclipse\\workspace\\tomcat_jk\\WEB-INF\\classes\\properties.xml";
		level = LoginBean.getAccountLevel("ã¥ñ{", "èCàÍ", path);
		System.out.println("level = " + level );
	}

}
