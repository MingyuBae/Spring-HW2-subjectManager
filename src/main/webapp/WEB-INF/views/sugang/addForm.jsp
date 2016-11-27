<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
	<jsp:include page="../layout/include.jsp"></jsp:include>
	<title>수강신청</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-xs-12">
				<div class="panel panel-primary">
					<div class="panel-heading">수강신청</div>
					<div class="panel-body">
						<form:form method="POST" action="${pageContext.request.contextPath }/sugang/add" modelAttribute="sugang" class="form-horizontal">
							<div class="form-group">
								<label for="course_code" class="col-sm-2 control-label">강의코드</label>
								<div class="col-sm-10">
									<form:input path="course_code" class="form-control"/>
								</div>
								<form:errors path="course_code" class="col-xs-12 text-right help-block"></form:errors>
							</div>
							<div class="form-group">
								<label for="course_name" class="col-sm-2 control-label">강의명</label>
								<div class="col-sm-10">
									<form:input path="course_name" class="form-control"/>
								</div>
								<form:errors path="course_name" class="col-xs-12 text-right help-block"></form:errors>
							</div>
							<div class="form-group">
								<label for="course_type" class="col-sm-2 control-label">강의종류</label>
								<div class="col-sm-10">
									<form:select path="course_type" class="form-control">
										<optgroup label="전공">
											<form:option value="전기">전기</form:option>
											<form:option value="전선">전선</form:option>
											<form:option value="전지">전지</form:option>
										</optgroup>
										<optgroup label="교양">
											<form:option value="교필">교필</form:option>
											<form:option value="자율">자율</form:option>
											<form:option value="토대">토대</form:option>
											<form:option value="인재">인재</form:option>
											<form:option value="일선">일선</form:option>
										</optgroup>
										<optgroup label="교직">
											<form:option value="교직">교직</form:option>
											<form:option value="교직선">교직선</form:option>
										</optgroup>
									</form:select>
								</div>
								<form:errors path="course_type" class="col-xs-12 text-right help-block"></form:errors>
							</div>
							<div class="form-group">
								<label for="course_point" class="col-sm-2 control-label">학점</label>
								<div class="col-sm-10">
									<form:input path="course_point" class="form-control"/>
								</div>
								<form:errors path="course_point" class="col-xs-12 text-right help-block"></form:errors>
							</div>
							
							<div class="row">
								<div class="col-xs-12 text-right">						
									<input type="submit" value="신청" class="btn btn-success"/>
								</div>
							</div>
						</form:form>
					</div>
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