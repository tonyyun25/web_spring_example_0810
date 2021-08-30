<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL core library</title>
</head>
<body>

	<c:set var="weight" value="88" />
	
	<c:choose>
		<c:when test="${weight <= 70 }">
			<h4>치킨먹자</h4>
		
		</c:when>
		<c:when test="${weight <= 80 }">
		 	<h4>샐러드먹자</h4>
		</c:when>
		<c:otherwise>
			<h4>굶자</h4>
		</c:otherwise>
		
		
		
	</c:choose>
	
	<c:forEach var="i" begin="0" end="4" step="1">
		${i }
	</c:forEach>
	
	
	<c:forEach var="i" begin="16" end="20" step="1" varStatus="status">
	
		${i },${status.current},${status.first},${status.last},${status.count},${status.index}</h4>
		<br>
	</c:forEach>
	
	<c:forEach var="fruit" items="${fruits }" varStatus="status">
		${fruit } :::: ${status.count },${status.index }<br>
	</c:forEach>
	


	
	<c:forEach var="user" items="${users }" varStatus="status">
	<h4>${status.count }번째 사람 정보</h4>
	이름 : ${user.name } 나이 : ${user.age } 취미 : ${user.hobby }
	</c:forEach>
	

	<table border="1">
		<thead>
			<th>번호</th>
			<th>이름</th>
			<th>나이</th>
			<th>취미</th>
		
		</thead>
		<tbody>
			<%-- 
			<tr>
				<td>1</td>	
				<td>둘리</td>
					<td>7</td>
					<td>날기</td>
			</tr>
			<tr>
				<td>2</td>	
				<td>고길동</td>
					<td>47</td>
					<td>화내기</td>
			</tr>--%>
			<c:forEach var="user" items="${users }" varStatus="status">
			<tr>
				<td>${status.count }</td>
				<td>${user.name }</td>
				<td>${user.age }</td>
				<td>${user.hobby }</td>
			</tr>
			</c:forEach>
		
		
		</tbody>
	
	
	</table>
	
	
	
	
	
	
	
	
	
	
	


</body>
</html>