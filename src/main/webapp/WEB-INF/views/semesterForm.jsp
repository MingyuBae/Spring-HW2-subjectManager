<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>
<head>
	<jsp:include page="layout/include.jsp"></jsp:include>
	<title>학기별 이수 학점 조회</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-xs-12">
				<div class="panel panel-info">
					<div class="panel-heading">학년/학기별 이수 총 학점</div>
					<table class="table table-striped">
						<thead>
							<tr>
								<th>수강년도</th>
								<th>학기</th>
								<th>이수 학점</th>
								<th>상세보기</th>
							</tr>
						</thead>
						<tbody>
						  <c:forEach var="semesterInfo" items="${semesterInfoList }">
							<tr>
								<td>${semesterInfo.course_year }</td>
								<td>${semesterInfo.course_semester }</td>
								<td>${semesterInfo.course_point }</td>
								<td><a href="${pageContext.request.contextPath }/semesterDetail?year=${semesterInfo.course_year }&semester=${semesterInfo.course_semester }">링크</a></td>
							</tr>
						  </c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-sm-12">
				<a href="${pageContext.request.contextPath }" class="btn btn-info"><span class="glyphicon glyphicon-home" aria-hidden="true"></span> 메인화면으로</a>
			</div>
		</div>
	</div>
</body>
</html>