package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import tomcat_jk.beans.Customer;
import tomcat_jk.util.RecordSet;
import java.util.Iterator;

public final class SearchResult_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      tomcat_jk.util.RecordSet hitResults = null;
      synchronized (request) {
        hitResults = (tomcat_jk.util.RecordSet) _jspx_page_context.getAttribute("hitResults", PageContext.REQUEST_SCOPE);
        if (hitResults == null){
          hitResults = new tomcat_jk.util.RecordSet();
          _jspx_page_context.setAttribute("hitResults", hitResults, PageContext.REQUEST_SCOPE);
        }
      }
      out.write('\r');
      out.write('\n');
      java.lang.String message = null;
      synchronized (request) {
        message = (java.lang.String) _jspx_page_context.getAttribute("message", PageContext.REQUEST_SCOPE);
        if (message == null){
          message = new java.lang.String();
          _jspx_page_context.setAttribute("message", message, PageContext.REQUEST_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

Integer level = new Integer( ( String )request.getAttribute( "level" ) );
System.out.println("level = " + level);

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head><title>検索結果</title></head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<center>\r\n");
      out.write("\t\r\n");
      out.write("\t<p>\r\n");
      out.write("\t\t<h2>ようこそ、");
      out.print( request.getAttribute( "accId" ) );
      out.write("さん。</h2>\r\n");
      out.write("\t</p>\r\n");
      out.write("\t\t\r\n");
      out.write("\t<table border=1 width=100%>\r\n");
      out.write("\t\t<tr nowrap>\r\n");
      out.write("\t\t\t<th nowrap>性別</th>\r\n");
      out.write("\t\t\t<th nowrap>年齢</th>\r\n");
      out.write("\t\t\t<th nowrap>職業</th>\r\n");

	if ( level != null ) {
		if ( level.intValue() >= 2 ) { 

      out.write("\r\n");
      out.write("\t\t\t<th nowrap>名前（ローマ字）</th>\r\n");
      out.write("\t\t\t<th nowrap>名前（漢字）</th>\r\n");
      out.write("\t\t\t<th nowrap>会社名</th>\r\n");
      out.write("\t\t\t<th nowrap>部署</th>\r\n");
      out.write("\t\t\t<th nowrap>役職</th>\r\n");
      out.write("\t\t\t<th nowrap>メールアドレス</th>\r\n");

		}
	} 

      out.write("\r\n");
      out.write("\t\t\t<th nowrap>都道府県</th>\r\n");
	if ( level != null ) { 
      out.write('\r');
      out.write('\n');
		if ( level.intValue() >= 2 ) { 
      out.write("\r\n");
      out.write("\t\t\t<th>住所</th nowrap>\r\n");
      out.write("\t\t\t<th nowrap>電話番号</th>\r\n");
      out.write("\t\t\t<th nowrap>携帯番号</th>\r\n");
 		} 
      out.write('\r');
      out.write('\n');
 	} 
      out.write("\r\n");
      out.write("\t\t\t<th nowrap>メモ</th>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\r\n");
	
//	System.out.println("hitResults.size() = " + hitResults.size());
//	System.out.println(hitResults.getList());
	Iterator iterator = hitResults.iterator();
	while(iterator.hasNext()) {
		Customer customer = (Customer)iterator.next();

      out.write('\r');
      out.write('\n');

		System.out.println(customer.getName_jp());
		if (customer == null ) return;

      out.write("\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t<td nowrap align=center>\r\n");
      out.write("\t\t\t");
      out.print( customer.getSex() );
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t<td nowrap align=center>\r\n");
      out.write("\t\t\t");
      out.print( customer.getAge() );
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t<td nowrap align=center>\r\n");
      out.write("\t\t\t");
      out.print( customer.getJob() );
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
	if (level != null) {
		if (level.intValue() >= 2 ) {

      out.write("\r\n");
      out.write("\t\t<td nowrap align=center>\r\n");
      out.write("\t\t\t");
      out.print( customer.getName() );
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t<td nowrap align=center>\r\n");
      out.write("\t\t\t");
      out.print( customer.getName_jp() );
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t<td nowrap align=center>\r\n");
      out.write("\t\t\t");
      out.print( customer.getCompany() );
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t<td nowrap align=center>\r\n");
      out.write("\t\t\t");
      out.print( customer.getDept() );
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t<td nowrap align=center>\r\n");
      out.write("\t\t\t");
      out.print( customer.getYakushoku() );
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t<td nowrap align=center>\r\n");
      out.write("\t\t\t");
      out.print( customer.getE_mail() );
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
 		} 
      out.write('\r');
      out.write('\n');
 	} 
      out.write("\r\n");
      out.write("\t\t<td nowrap align=center>\r\n");
      out.write("\t\t\t");
      out.print( customer.getPref() );
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
 //System.out.println("(level.intValue() >= 2 ): " + (level.intValue() >= 2 )); 
      out.write('\r');
      out.write('\n');
	if ( level != null && level.intValue() >= 2 ) { 
      out.write("\r\n");
      out.write("\t\t<td nowrap align=center>\r\n");
      out.write("\t\t\t");
      out.print( customer.getAddress() );
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t<td nowrap align=center>\r\n");
      out.write("\t\t\t");
      out.print( customer.getPhone() );
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t<td nowrap align=center>\r\n");
      out.write("\t\t\t");
      out.print( customer.getCell_phone() );
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\r\n");
 	} 
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t<td nowrap align=center>\r\n");
      out.write("\t\t\t");
      out.print( customer.getMemo() );
      out.write("\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
 } 
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t</table>\r\n");
      out.write("\t</center>\r\n");
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
