<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<jsp:include page="../layout/include.jsp"></jsp:include>
	<script>
		$(function(){
			$('.removeBtn').click(function (){
				var course_code = $(this).parent().parent().attr('data-course_code');
				var course_name =  $(this).parent().parent().attr('data-course_name');
				
				if(confirm(course_name + ' 수강신청을 삭제하시겠습니까?')){
					$('#submitForm [name="course_code"]').val(course_code);
					$('#submitForm').submit();
				}
			});
		});
	</script>
	
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
								<th>삭제</th>
							</tr>
						</thead>
						<tbody>
						  <c:forEach var="sugang" items="${sugangList }">
							<tr data-course_code="${sugang.course_code }" data-course_name="${sugang.course_name }">
								<td class="sugang_id">${sugang.sugang_id }</td>
								<td class="course_code">${sugang.course_code }</td>
								<td class="course_name">${sugang.course_name }</td>
								<td class="course_type">${sugang.course_type }</td>
								<td class="course_point">${sugang.course_point }</td>
								<td><button class="btn btn-danger btn-xs removeBtn"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button></td>
							</tr>
						  </c:forEach>
						</tbody>
					</table>
					<form id="submitForm" action="${pageContext.request.contextPath }/sugang/delete" method="POST">
						<input type="hidden" name="course_code" />
					</form>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-xs-12">
				<div class="panel panel-success">
					<div class="panel-heading">이수구분별 수강신청내역</div>
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
			</div>
		</div>
	</div>

</body>
</html>