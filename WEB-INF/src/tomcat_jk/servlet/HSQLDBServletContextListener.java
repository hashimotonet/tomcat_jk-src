package tomcat_jk.servlet;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import javax.servlet.*;

import tomcat_jk.util.PropertyReader;

public class HSQLDBServletContextListener implements ServletContextListener {
    
//    private static final String DB_URL    = "jdbc:hsqldb:hsql://localhost:9001";
//    private static final String DB_DRIVER = "org.hsqldb.jdbcDriver";
//    private static final String DB_USER   = "sa";
//    private static final String DB_PASS   = "";
//    private static final String DATA_DIR  = "WEB-INF/data";
    
    private String dbUrl;
    private String dbDriver;
    private String dbUser;
    private String dbPass;
    private String dataDir;
    
    public HSQLDBServletContextListener() throws Exception {
    }
    
    protected void setProperties(String filePath) 
		throws FileNotFoundException,
			IOException {
		PropertyReader propReader = new PropertyReader();
		propReader.loadFromXML(filePath);
//		propReader.loadFromXML("C:\\java\\properties.xml");
		dbUrl = propReader.getProperty("DB_URL");
		dbDriver = propReader.getProperty("DB_DRIVER");
		dbUser  = propReader.getProperty("dbId");
		dbPass = propReader.getProperty("dbPwd");
		dataDir = propReader.getProperty("DATA_DIR");
	}
    
    public void contextInitialized(ServletContextEvent evt) {
        System.out.println("HSQLDB‚ð‹N“®‚µ‚Ü‚·");
    	

    	try {
            ServletContext context = evt.getServletContext();
        	setProperties(context.getRealPath("WEB-INF/classes/properties.xml"));
            org.hsqldb.Server.main(new String[]{"-database",context.getRealPath(dataDir + "/TEST"),
                                                "-no_system_exit","true"});
        } catch(RuntimeException ex){
            throw ex;
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }
    
    public void contextDestroyed(ServletContextEvent evt) {
        System.out.println("HSQLDB‚ð’âŽ~‚µ‚Ü‚·");
    	try {
            Class.forName(dbDriver);
            Connection conn = DriverManager.getConnection(dbUrl,dbUser,dbPass);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("SHUTDOWN;");
            stmt.close();
            conn.close();
        } catch(RuntimeException ex){
            throw ex;
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }
}
