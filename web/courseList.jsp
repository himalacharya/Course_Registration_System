<%--
  Created by IntelliJ IDEA.
  User: Himal Acharya
  Date: 2016-09-09
  Time: 9:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="SITE_URL" value="${pageContext.request.contextPath}"></c:set>



<jsp:include page="partials/adminheader.jsp"/>

<c:if test="${!empty courses}">
    <div class="container">
        <table class="table">
            <thead>
            <tr>
                <th>Student ID</th>
                <th>Student Name</th>
                <th>Course Name</th>
                <th>Course Description</th>
                <th>Course Duration</th>
                <th>Course Type</th>
                <th>Added Date</th>
                <th>Modified Date</th>
                <th>Status</th>
                <th>Action</th>
                <th>Email</th>


            </tr>
            </thead>
            <tbody>
            <c:forEach items="${courses}" var="courses">
                <tr>
                    <td><c:out value="${courses.courseId }"/></td>
                    <td><c:out value="${courses.userName }"/></td>
                    <td><c:out value="${courses.courseName }"/></td>
                    <td><c:out value="${courses.courseDescription }"/></td>
                    <td><c:out value="${courses.courseDuration}"/></td>
                    <td><c:out value="${courses.durationType}"/></td>
                    <td><c:out value="${courses.addeddate}"/></td>
                    <td><c:out value="${courses.modifiedDate}"/></td>
                    <td>
                       <c:choose>
                           <c:when test="${courses.status}">
                               Active
                           </c:when>
                           <c:otherwise>
                               Inactive
                           </c:otherwise>
                       </c:choose>
                    </td>
                    <div class="form-group">
                        <div class="btn-group">
                            <td style="width: 175px;"><a
                                    href="CourseController?action=edit&courseId=<c:out value="${courses.courseId}"/>"><button class="btn btn-lg btn-default "><span class="glyphicon glyphicon-edit"></span></button></a>
                                <a
                                        href="CourseController?action=delete&courseId=<c:out value="${courses.courseId}"/>"><button class="btn btn-lg btn-default "><span class="glyphicon glyphicon-trash"></span></button></a>

                            </td>
                        </div>
                    </div>
                    <td><a href="CourseController?action=email&courseId=<c:out value="${courses.courseId}"/>" ><button class="btn btn-lg btn-default "><span class="glyphicon glyphicon-envelope"></span></button></a></td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</c:if>

<jsp:include page="partials/footer.jsp"/>

