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
<head><title>検索結果</title></head>
<body>
	<center>
	
	<p>
		<h2>ようこそ、<%= request.getAttribute( "accId" ) %>さん。</h2>
	</p>
		
	<table border=1 width=100%>
		<tr nowrap>
			<th nowrap>性別</th>
			<th nowrap>年齢</th>
			<th nowrap>職業</th>
<%
	if ( level != null ) {
		if ( level.intValue() >= 2 ) { 
%>
			<th nowrap>名前（ローマ字）</th>
			<th nowrap>名前（漢字）</th>
			<th nowrap>会社名</th>
			<th nowrap>部署</th>
			<th nowrap>役職</th>
			<th nowrap>メールアドレス</th>
<%
		}
	} 
%>
			<th nowrap>都道府県</th>
<%	if ( level != null ) { %>
<%		if ( level.intValue() >= 2 ) { %>
			<th>住所</th nowrap>
			<th nowrap>電話番号</th>
			<th nowrap>携帯番号</th>
<% 		} %>
<% 	} %>
			<th nowrap>メモ</th>
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
