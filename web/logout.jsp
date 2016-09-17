<%--
  Created by IntelliJ IDEA.
  User: Himal Acharya
  Date: 2016-09-13
  Time: 12:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%
    request.getSession().invalidate();
    response.sendRedirect("/login.jsp");
%>