<%--
  Created by IntelliJ IDEA.
  User: Himal Acharya
  Date: 2016-09-08
  Time: 7:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="partials/loginheader.jsp"/>


<div class="container">
    <div class="row">
        <h1 style="text-align: center">Student Account</h1>
        <div style="width:30%;margin: 0 auto;">
            <form action="CourseController" method="post">

                <div class="form-group">
                    <label class="text">Student ID</label>
                    <input type="text" class="form-control" name="courseId" value="${course.courseId}"
                           placeholder="readonly" readonly="readonly">
                </div>

                <div class="form-group">
                    <label class="text">User Name</label>
                    <input type="text" class="form-control" name="userName" value="${course.userName}">
                </div>

                <div class="form-group">
                    <label class="password-field">Password</label>
                    <input type="password" class="form-control" name="password" value="${course.password}">
                </div>

                <div class="form-group">
                    <label class="text">Email</label>
                    <input type="text" name="email" class="form-control" value="${course.email}">
                </div>

                <div class="form-group">
                    <label class="text">Course Name</label>
                    <input type="text" class="form-control" name="courseName" value="${course.courseName}">
                </div>

                <div class="form-group">
                    <label class="text">Course Description</label>
                    <input type="text" class="form-control" name="courseDescription"
                           value="${course.courseDescription}">
                </div>

                <div class="form-group">
                    <label class="text">Length of Course</label>
                    <input type="text" class="form-control" name="courseDuration" value="${course.courseDuration}">
                </div>


                <div class="form-group">
                    <label class="text">Course Type</label>
                    <input type="text" class="form-control" name="durationType" value="${course.durationType}">
                </div>

                <div class="col-xs-18">Clicking <stronger>Submit </stronger>means that you agree to the Course Registration Agreements and Terms & Conditions.</div>

                <div class="form-group">
                    <button class="btn btn-primary btn-block">Submit</button>
                </div>

            </form>


        </div>
    </div>
</div>




<jsp:include page="partials/footer.jsp"/>
