<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>
<head>
	<jsp:include page="layout/include.jsp"></jsp:include>
	<title>이수 학점 조회</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-xs-12">
				<div class="panel panel-info">
					<div class="panel-heading">${year }학년 ${semester }학기 이수학점</div>
					<table class="table table-bordered table-striped">
						<thead>
							<tr>
								<th>수강년도</th>
								<th>학기</th>
								<th>교과코드</th>
								<th>교과목명</th>
								<th>구분</th>
								<th>학점</th>
							</tr>
						</thead>
						<tbody>
						  <c:forEach var="course" items="${courseList }">
							<tr>
								<td>${course.course_year }</td>
								<td>${course.course_semester }</td>
								<td>${course.course_code }</td>
								<td>${course.course_name }</td>
								<td>${course.course_type }</td>
								<td>${course.course_point }</td>
							</tr>
						  </c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-xs-12">
				<div class="panel panel-success">
					<div class="panel-heading">이수구분별 학점내역</div>
					<table class="table table-bordered">
						<thead>
							<tr>
							  <c:forEach var="summary" items="${summaryList }">
								<th>${summary.course_type}</th>
							  </c:forEach>
							</tr>
						</thead>
						<tbody>
							<tr>
							  <c:forEach var="summary" items="${summaryList }">
								<td>${summary.course_point}</td>
							  </c:forEach>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-xs-12">
				<a href="${pageContext.request.contextPath }" class="btn btn-info"><span class="glyphicon glyphicon-home" aria-hidden="true"></span> 메인화면으로</a>
				<a href="${pageContext.request.contextPath }/semesterSummary" class="btn btn-success"><span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span> 뒤로가기</a>
			</div>
		</div>
	</div>
</body>
</html>