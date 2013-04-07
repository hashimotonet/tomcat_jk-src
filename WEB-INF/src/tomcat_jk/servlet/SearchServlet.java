package tomcat_jk.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.arnx.jsonic.JSON;
import tomcat_jk.dao.SearchDAO;
import tomcat_jk.util.RecordSet;

/**
 * 
 * 
 * @author Osamu Hashimoto osm@yha.att.ne.jp
 *
*/

public class SearchServlet extends HttpServlet {

//	Connection conn;
	String dbUrl;
	String dbId;
	String dbPwd;
	String msg = "�Ȃ��B";
//	boolean bDebugOn = false;
	
	/**
	 *
	 * �T�[�u���b�g�̋N�����ɂP�񂾂����s����܂��B
	 *
	 * @param �Ȃ�
	 *
	*/
	public void init() {
		
		try {
			Class.forName( "org.hsqldb.jdbcDriver" );
		} catch( ClassNotFoundException ex ) {
			ex.printStackTrace();
			this.msg = ex.getMessage();
		}
	}
	
	/**
	 *
	 * �F�؉�ʂ���R�[�����ꂽ�ۂ̏������s���܂�(����̃��C������)�B
	 * 
	 * @param HttpServletRequest  request
	 * @param HttpServletResponse response
	 *
	*/
	public void doPost( HttpServletRequest request, HttpServletResponse response ) {
		
//		System.getProperties().list(System.out);
		
//		HttpSession session = request.getSession();
//		if ( session.isNew() || request.getParameter( "id" ) == null ) {
//			try {
//				response.sendRedirect( "/tomcat_jk/Login.jsp" );
//				return;
//			} catch ( IOException ex ) {
//				ex.printStackTrace();
//				this.msg = ex.getMessage();
//			}
//		}
		
		String id  = request.getParameter( "id" );
		request.setAttribute( "accId", id );
		
//		String level  = ( String )session.getAttribute( "level" );

//		System.out.println( "SearchServlet : level = " + level );
//		request.setAttribute( "level", level );
		
		RecordSet searchResult = new RecordSet();
		searchResult = searchDatabase();
		

		request.setAttribute( "hitResults", searchResult );
		request.setAttribute( "message", this.msg );
		
		boolean ajax = true;
		if ( ajax ) {
			String json = JSON.encode(searchResult, true);
			response.setContentType("text/javascript");
			response.setCharacterEncoding("UTF-8");
			try {
				PrintWriter out = response.getWriter();
				out.println(json);
			} catch(IOException ex) {
				ex.printStackTrace();
			}
		} else {
			try {
				ServletContext sc = getServletContext();
				RequestDispatcher rd = sc.getRequestDispatcher( "/SearchResult.jsp" );
		
				rd.forward( request, response );
			} catch ( ServletException ex ) {
				ex.printStackTrace();
				this.msg = ex.getMessage();
			} catch ( IOException ex ) {
				ex.printStackTrace();
				this.msg = ex.getMessage();
			}
	}
		
//		conn = null;
		System.out.println( "�N��������O : " + this.msg );
	}
	
	/**
	 *
	 * ��Servlet��URL�𒼐ڃL�b�N���ꂽ�ۂɁA������doPost() �ɐU��܂��B
	 * 
	 * @param HttpServletRequest  request
	 * @param HttpServletResponse response
	 *
	*/
	public void doGet( HttpServletRequest request, HttpServletResponse response ) {
		doPost( request, response );
	}
	
	/**
	 *
	 * DB���������s���ARecordSet�^�Ńf�[�^��Ԃ��܂�
	 * 
	 * @param String sqlStatement
	*/
	protected RecordSet searchDatabase() {
		
		System.out.println("hello.");
		SearchDAO dao = new SearchDAO();
		RecordSet records = null;
		ResultSet rResult = null;
		String filePath = getServletContext().getRealPath("WEB-INF/classes/properties.xml");
		dao.setFilePath(filePath);
		dao.execute(filePath);
		records = dao.getRecordSet();
		
		System.out.println("SearchServlet#searchDatabase records.size() = " + records.size());
		
		return records;
	}

	
	/**
	 * �T�[�u���b�g�̃A�����[�h����1�񂾂����s����܂��B
	 *
	 * @param �Ȃ��B
	*/
	public void destroy() {
		System.out.println("destroy.");
	}
}