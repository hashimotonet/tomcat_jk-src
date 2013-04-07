<%@page language="java"
		pageEncoding="Shift_JIS"
		contentType="text/html; charset=Shift_JIS"
		import="tomcat_jk.beans.LoginBean, java.io.IOException"
%>
<jsp:useBean id="level" scope="page" class="java.lang.String" />
<% String message = "Web�A�v���P�[�V�����F�؃��O�C����ʂł��B"; %>
<%!
void displayAlert(JspWriter out) throws IOException {
	out.println( "<script language=\"JavaScript\">" );
	out.println( "alert( \"�o�^����Ă��Ȃ�ID�A�܂��̓p�X���[�h�ł��B\" );" );
	out.println( "history.back();" );
	out.println( "</script>" );
	// �u���E�U�̐ݒ��JavaScript���I�t�ɂȂ��Ă���ꍇ�ɂ́A���L�̃R�����g���u���E�U�ŕ\��
	out.println( "�o�^����Ă��Ȃ�ID�A�܂��̓p�X���[�h�ł��B" );
}
%>
<html>
<head><title>Jakarta�O��U��Web�A�v���P�[�V����</title></head>
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
				�u���E�U�̖߂�{�^���ŔF�؉�ʂɖ߂�A�ēx�F�؂��s���Ă��������B
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
		<tr><td align=center> �h�c </td><td><input type=text name=id></td></tr>
		<tr><td align=center> �p�X���[�h </td><td><input type=text name=pwd></td></tr>
		<tr><td><input type=submit value=���O�C��></td><td align=center><input type=reset></td></tr>
	</table>
</form>
<%	}	%>
</body>
</html>
