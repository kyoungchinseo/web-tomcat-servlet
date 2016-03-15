<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="kr">
<head>
    <%@include file="../common/header.jsp" %>
</head>
<body>

	<%@include file="../common/navigation.jsp"  %>

	<div class="container" id="main">
	   <div class="col-md-10 col-md-offset-1">
	      <div class="panel panel-default">
	          <table class="table table-hover">
	              <thead>
	                <tr>
	                    <th>#</th> <th>사용자 아이디</th> <th>이름</th> <th>이메일</th><th></th>
	                </tr>
	              </thead>
	              <tbody>
	              	<c:forEach items ="${users }" var="user" varStatus="usersCount">
	              		<tr>
	              			<th scope="row">${usersCount.count}</th> 
	              			<td>${user.userId }</td> 
	              			<td>${user.name }</td> 
	              			<td>${user.email }</td>
	              			<td><a href="/user/updateForm?userId=${user.userId}" class="btn btn-success" role="button">수정</a></td>
	              		</tr>
	              	
	              	</c:forEach>
	              
	              </tbody>
	          </table>
	        </div>
	    </div>
	</div>
	
	<%@include file="../common/reference.jsp"  %>
</body>
</html>