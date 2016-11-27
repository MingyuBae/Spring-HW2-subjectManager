<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>
<head>
	<jsp:include page="layout/include.jsp"></jsp:include>
	<title>이수 구분별 학점 내역</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-xs-12">
				<div class="panel panel-success">
					<div class="panel-heading">이수 구분별 학점 내역</div>
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
			<div class="col-sm-12">
				<a href="${pageContext.request.contextPath }" class="btn btn-info"><span class="glyphicon glyphicon-home" aria-hidden="true"></span> 메인화면으로</a>
			</div>
		</div>
	</div>
</body>
</html>