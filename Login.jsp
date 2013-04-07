<%@page language="java"
		pageEncoding="Shift_JIS"
		contentType="text/html; charset=Shift_JIS"
		import="tomcat_jk.beans.LoginBean, java.io.IOException"
%>
<jsp:useBean id="level" scope="page" class="java.lang.String" />
<% String message = "Webアプリケーション認証ログイン画面です。"; %>
<%!
void displayAlert(JspWriter out) throws IOException {
	out.println( "<script language=\"JavaScript\">" );
	out.println( "alert( \"登録されていないID、またはパスワードです。\" );" );
	out.println( "history.back();" );
	out.println( "</script>" );
	// ブラウザの設定でJavaScriptがオフになっている場合には、下記のコメントをブラウザで表示
	out.println( "登録されていないID、またはパスワードです。" );
}
%>
<html>
<head><title>Jakarta徹底攻略Webアプリケーション</title></head>
<body>
<h3><%= message %></h3>

<%	 
	 String id = request.getParameter( "id" );
	 String pwd = request.getParameter("pwd");
	 String path = getServletContext().getRealPath("WEB-INF/classes/properties.xml");

	System.out.println("id = " + id + ", pwd = " + pwd);
	if ( ( id != null ) && (pwd != null)){
		 if ( !id.equals( "" ) && !pwd.equals("") ) {
			level = LoginBean.getAccountLevel( id, pwd, path );
		
			if ( ( level == null ) || level.equals( "" ) ) {
				displayAlert(out);
%>
				ブラウザの戻るボタンで認証画面に戻り、再度認証を行ってください。
<%
				return;
			} else {
				session.setAttribute( "id", id );
				session.setAttribute( "level", level );
				getServletContext().getRequestDispatcher( "/servlet/SearchServlet" ).forward( request, response );
			}
		 } else {
			 displayAlert(out);
		 }
%>
		<form name=Login_Form method=post>
			<input type=hidden name=id value=<%= id %>>
		</form>
<%	} else { %>
<form name=account method=post action=Login.jsp>
	<table border=1>
		<tr><td align=center> ＩＤ </td><td><input type=text name=id></td></tr>
		<tr><td align=center> パスワード </td><td><input type=text name=pwd></td></tr>
		<tr><td><input type=submit value=ログイン></td><td align=center><input type=reset></td></tr>
	</table>
</form>
<%	}	%>
</body>
</html>
