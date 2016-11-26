<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<jsp:include page="../layout/include.jsp"></jsp:include>
	<title>수강신청 목록</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-xs-12">
				<div class="panel panel-info">
					<div class="panel-heading">수강신청 목록</div>
					<table class="table table-bordered table-striped">
						<thead>
							<tr>
								<th>no</th>
								<th>교과코드</th>
								<th>교과목명</th>
								<th>구분</th>
								<th>학점</th>
								<th>취소</th>
							</tr>
						</thead>
						<tbody>
						  <c:forEach var="sugang" items="${sugangList }">
							<tr>
								<td>${sugang.sugang_id }</td>
								<td>${sugang.course_code }</td>
								<td>${sugang.course_name }</td>
								<td>${sugang.course_type }</td>
								<td>${sugang.course_point }</td>
								<td><a href="${sugang.sugang_id }">취소</a></td>
							</tr>
						  </c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>

</body>
</html>