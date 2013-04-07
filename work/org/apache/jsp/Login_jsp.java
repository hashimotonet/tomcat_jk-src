package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import tomcat_jk.beans.LoginBean;
import java.io.IOException;

public final class Login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


void displayAlert(JspWriter out) throws IOException {
	out.println( "<script language=\"JavaScript\">" );
	out.println( "alert( \"登録されていないID、またはパスワードです。\" );" );
	out.println( "history.back();" );
	out.println( "</script>" );
	// ブラウザの設定でJavaScriptがオフになっている場合には、下記のコメントをブラウザで表示
	out.println( "登録されていないID、またはパスワードです。" );
}

  private static java.util.List _jspx_dependants;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html; charset=Shift_JIS");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');
      java.lang.String level = null;
      synchronized (_jspx_page_context) {
        level = (java.lang.String) _jspx_page_context.getAttribute("level", PageContext.PAGE_SCOPE);
        if (level == null){
          level = new java.lang.String();
          _jspx_page_context.setAttribute("level", level, PageContext.PAGE_SCOPE);
        }
      }
      out.write('\r');
      out.write('\n');
 String message = "Webアプリケーション認証ログイン画面です。"; 
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head><title>Jakarta徹底攻略Webアプリケーション</title></head>\r\n");
      out.write("<body>\r\n");
      out.write("<h3>");
      out.print( message );
      out.write("</h3>\r\n");
      out.write("\r\n");
	 
	 String id = request.getParameter( "id" );
	 String pwd = request.getParameter("pwd");
	 String path = getServletContext().getRealPath("WEB-INF/classes/properties.xml");

	System.out.println("id = " + id + ", pwd = " + pwd);
	if ( ( id != null ) && (pwd != null)){
		 if ( !id.equals( "" ) && !pwd.equals("") ) {
			level = LoginBean.getAccountLevel( id, pwd, path );
		
			if ( ( level == null ) || level.equals( "" ) ) {
				displayAlert(out);

      out.write("\r\n");
      out.write("\t\t\t\tブラウザの戻るボタンで認証画面に戻り、再度認証を行ってください。\r\n");

				return;
			} else {
				session.setAttribute( "id", id );
				session.setAttribute( "level", level );
				getServletContext().getRequestDispatcher( "/servlet/SearchServlet" ).forward( request, response );
			}
		 } else {
			 displayAlert(out);
		 }

      out.write("\r\n");
      out.write("\t\t<form name=Login_Form method=post>\r\n");
      out.write("\t\t\t<input type=hidden name=id value=");
      out.print( id );
      out.write(">\r\n");
      out.write("\t\t</form>\r\n");
	} else { 
      out.write("\r\n");
      out.write("<form name=account method=post action=Login.jsp>\r\n");
      out.write("\t<table border=1>\r\n");
      out.write("\t\t<tr><td align=center> ＩＤ </td><td><input type=text name=id></td></tr>\r\n");
      out.write("\t\t<tr><td align=center> パスワード </td><td><input type=text name=pwd></td></tr>\r\n");
      out.write("\t\t<tr><td><input type=submit value=ログイン></td><td align=center><input type=reset></td></tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("</form>\r\n");
	}	
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
