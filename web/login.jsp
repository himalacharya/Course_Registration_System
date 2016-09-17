<%--
  Created by IntelliJ IDEA.
  User: Himal Acharya
  Date: 2016-09-13
  Time: 10:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="SITE_URL" value="${pageContext.request.contextPath}"></c:set>


<jsp:include page="partials/loginheader.jsp"/>


<div class="container">
    <div class="row">
        <h1 style="text-align: center">Login</h1>
        <div style="width:30%;margin: 0 auto;">
            <form action="${SITE_URL}/login" method="post">
                <div class="form-group">
                    <input class="form-control" type="text" name="username" placeholder="Username"></div>
                <div class="form-group">
                    <input class="form-control" type="password" name="password" placeholder="password"></div>
                <div class="form-group">
                    <button class="btn btn-lg btn-primary btn-block">Login!</button>
                </div>
                <div class="form-group">
                    <p> New Student? <a href="${SITE_URL}/course.jsp">Register!</a> </p>
                </div>


            </form>
            <c:if test="${param.error!=null}">


            <div class="alert alert-info ">
                <a href="/login.jsp" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                <strong>Invalid Username or Password</strong>
            </div>



            </c:if>
            <c:if test="${param.inactive!=null}">

                <div class="alert alert-danger ">
                    <a href="/login.jsp" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    <strong> CURRENTLY BLOCKED! Your account is not in active mode ! Either you are already graduated or have some technical issues in your course Contact Admin </strong>
                </div>


            </c:if>


        </div>
    </div>
</div>

<jsp:include page="partials/footer.jsp"/>