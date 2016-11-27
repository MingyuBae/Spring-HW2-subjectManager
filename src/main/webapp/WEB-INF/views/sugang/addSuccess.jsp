<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="../layout/include.jsp"></jsp:include>
	<title>수강신청 성공</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-xs-12">
				<div class="alert alert-success" role="alert">
					수강신청이 완료되었습니다
				</div>
			</div>
		</div>
	
		<div class="row">
			<div class="col-sm-12">
				<a href="${pageContext.request.contextPath }" class="btn btn-info"><span class="glyphicon glyphicon-home" aria-hidden="true"></span> 메인화면으로</a>
				<a href="${pageContext.request.contextPath }/sugang/add" class="btn btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span> 추가 신청</a>
			</div>
		</div>
	</div>
</body>
</html>