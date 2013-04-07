package tomcat_jk.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import tomcat_jk.beans.Customer;
import tomcat_jk.util.SQLWrapper;
import tomcat_jk.util.PropertyReader;
import tomcat_jk.util.RecordSet;

public class SearchDAO {
	private SQLWrapper _conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private String dbUrl;
	private String dbId;
	private String dbPwd;
	private String loginSql;
	private String searchSql;
	private RecordSet recordSet;
	private String filePath;
	
	private static final long serialVersionUID = 0L;


	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	protected void getProps() 
	throws FileNotFoundException,
		IOException {
	PropertyReader propReader = new PropertyReader();
	propReader.loadFromXML(this.filePath);
//	propReader.loadFromXML("C:\\java\\properties.xml");
	dbUrl = propReader.getProperty("dbUrl");
	dbId  = propReader.getProperty("dbId");
	dbPwd = propReader.getProperty("dbPwd");
	searchSql = propReader.getProperty("statement_2");
	
//	System.out.println(propReader);
}

	protected void getProps(String filePath) 
		throws FileNotFoundException,
				IOException {
		PropertyReader propReader = new PropertyReader();
		propReader.loadFromXML(this.filePath);
		dbUrl = propReader.getProperty("dbUrl");
		dbId  = propReader.getProperty("dbId");
		dbPwd = propReader.getProperty("dbPwd");
		searchSql = propReader.getProperty("statement_2");
		
	}

	public void execute(String filePath) {
		
		try {
			getProps(filePath);
			
			_conn = SQLWrapper.getInstance();
			_conn.getConnection(filePath);
			_conn.prepareStatement(searchSql);
			rs = _conn.executeQuery();
			setResult(rs);
//			System.out.println("this.recordSet = " + this.recordSet );
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if ( rs != null ) rs.close();
				if (_conn != null) _conn.close();
			} catch(SQLException sqle) {
				sqle.printStackTrace();
			}
		}
	}
	
	/**
	 *
	 * DB検索を実行し、RecordSet型でデータを返します
	 * 
	 * @param String sqlStatement
	*/
	protected void searchDatabase( String sqlStatement, String filePath ) {
		
		SearchDAO dao = new SearchDAO();
		ResultSet rResult = null;
		
		try {
			SQLWrapper connHandler = SQLWrapper.getInstance();
			connHandler.getConnection(filePath);
			connHandler.prepareStatement(sqlStatement);
			rResult = connHandler.executeQuery();
			recordSet = this.setResult( rResult );
			rResult.close();
			connHandler.close();
		} catch ( Exception ex ) {
			ex.printStackTrace();
		} finally {
			
			rResult = null;
		}
		
	}
	
	
	public RecordSet getRecordSet() {
		return this.recordSet;
	}

	protected RecordSet setResult( ResultSet rResult ) {
		Customer customer = null;
		try {
			recordSet = new RecordSet();
			while( rResult.next() ) {
				
				customer = new Customer();
				
				customer.setWeb_account_level(rResult.getInt( "account_level" ));
				customer.setSex(rResult.getString( "sex" ));
				customer.setAge(rResult.getInt( "age" ));
				customer.setName(rResult.getString( "name" ));
				customer.setName_jp(rResult.getString( "name_jp" ));
				customer.setJob(rResult.getString( "job" ));
				customer.setCompany(rResult.getString( "company" ));
				customer.setDept(rResult.getString( "dept" ));
				customer.setYakushoku(rResult.getString( "yakushoku" ));
				customer.setE_mail(rResult.getString( "e_mail" ));
				customer.setPref(rResult.getString( "pref" ));
				customer.setAddress(rResult.getString( "address" ));
				customer.setPhone(rResult.getString( "phone" ));
				customer.setCell_phone(rResult.getString( "cell_phone" ));
				customer.setMemo(rResult.getString( "memo" ));
				
				recordSet.addCustomer(customer);
				
			}
		} catch ( SQLException ex ) {
			ex.printStackTrace();
		}
		
		System.out.println("records.size() = " + recordSet.size());
		
		return recordSet;
	}
	

}
