<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<jsp:include page="layout/include.jsp"></jsp:include>
	<title>Home</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-8">
				<div class="list-group">
					<a href="${pageContext.request.contextPath }/semesterSummary" class="list-group-item">
						<h4 class="list-group-item-heading">학기별 이수학점 조회</h4>
						<p class="list-group-item-text">수강년도, 학기별로 이수 총 학점을 조회합니다.</p>
					</a>

					<a href="${pageContext.request.contextPath }/pointSummary" class="list-group-item">
						<h4 class="list-group-item-heading">이수 구분별 학점 조회</h4>
						<p class="list-group-item-text">교과목 이수 구분별 학점 취득 현황을 조회합니다.</p>
					</a>

					<a href="${pageContext.request.contextPath }/sugang/add" class="list-group-item">
						<h4 class="list-group-item-heading">수강 신청</h4>
						<p class="list-group-item-text">2017년 1학기에 신청할 예상 교과목을 신청합니다.</p>
					</a>
					<a href="${pageContext.request.contextPath }/sugang/list" class="list-group-item">
						<h4 class="list-group-item-heading">수강 신청 조회</h4>
						<p class="list-group-item-text">수강신청 메뉴를 통해 신청한 신청내역을 조회합니다.</p>
					</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>