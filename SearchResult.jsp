<%@ page language="java" %>
<%@ page import="tomcat_jk.beans.Customer"%>
<%@ page import= "tomcat_jk.util.RecordSet" %>
<%@ page import= "java.util.Iterator" %>
<%@ page pageEncoding="Shift_JIS" %>
<%@ page contentType="text/html; charset=Shift_JIS" %>

<jsp:useBean id="hitResults" scope="request" class="tomcat_jk.util.RecordSet" />
<jsp:useBean id="message"	 scope="request" class="java.lang.String" />


<%-- 
<bean:iterate>
	<bean:write property=""/>
</bean:iterate>
--%>

<%
Integer level = new Integer( ( String )request.getAttribute( "level" ) );
System.out.println("level = " + level);
%>

<html>
<head><title>��������</title></head>
<body>
	<center>
	
	<p>
		<h2>�悤�����A<%= request.getAttribute( "accId" ) %>����B</h2>
	</p>
		
	<table border=1 width=100%>
		<tr nowrap>
			<th nowrap>����</th>
			<th nowrap>�N��</th>
			<th nowrap>�E��</th>
<%
	if ( level != null ) {
		if ( level.intValue() >= 2 ) { 
%>
			<th nowrap>���O�i���[�}���j</th>
			<th nowrap>���O�i�����j</th>
			<th nowrap>��Ж�</th>
			<th nowrap>����</th>
			<th nowrap>��E</th>
			<th nowrap>���[���A�h���X</th>
<%
		}
	} 
%>
			<th nowrap>�s���{��</th>
<%	if ( level != null ) { %>
<%		if ( level.intValue() >= 2 ) { %>
			<th>�Z��</th nowrap>
			<th nowrap>�d�b�ԍ�</th>
			<th nowrap>�g�єԍ�</th>
<% 		} %>
<% 	} %>
			<th nowrap>����</th>
		</tr>

<%	
//	System.out.println("hitResults.size() = " + hitResults.size());
//	System.out.println(hitResults.getList());
	Iterator iterator = hitResults.iterator();
	while(iterator.hasNext()) {
		Customer customer = (Customer)iterator.next();
%>
<%
		System.out.println(customer.getName_jp());
		if (customer == null ) return;
%>
		<tr>
		<td nowrap align=center>
			<%= customer.getSex() %>
		</td>
		<td nowrap align=center>
			<%= customer.getAge() %>
		</td>
		<td nowrap align=center>
			<%= customer.getJob() %>
		</td>
<%	if (level != null) {
		if (level.intValue() >= 2 ) {
%>
		<td nowrap align=center>
			<%= customer.getName() %>
		</td>
		<td nowrap align=center>
			<%= customer.getName_jp() %>
		</td>
		<td nowrap align=center>
			<%= customer.getCompany() %>
		</td>
		<td nowrap align=center>
			<%= customer.getDept() %>
		</td>
		<td nowrap align=center>
			<%= customer.getYakushoku() %>
		</td>
		<td nowrap align=center>
			<%= customer.getE_mail() %>
		</td>
<% 		} %>
<% 	} %>
		<td nowrap align=center>
			<%= customer.getPref() %>
		</td>
<% //System.out.println("(level.intValue() >= 2 ): " + (level.intValue() >= 2 )); %>
<%	if ( level != null && level.intValue() >= 2 ) { %>
		<td nowrap align=center>
			<%= customer.getAddress() %>
		</td>
		<td nowrap align=center>
			<%= customer.getPhone() %>
		</td>
		<td nowrap align=center>
			<%= customer.getCell_phone() %>
		</td>

<% 	} %>

		<td nowrap align=center>
			<%= customer.getMemo() %>
		</td>
		</tr>
<% } %>

	</table>
	</center>
</body>
</html>
