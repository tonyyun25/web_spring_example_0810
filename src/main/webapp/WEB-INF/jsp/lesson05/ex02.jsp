<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL core 라이브러리</title>
</head>
<body>
	<h2>조건문 (c:choose c:when c:otherwise)</h2>
	<%-- 70kg 이하면 치킨, 80kg 이하면 샐러드 그게 아니면 굶기 --%>

	<c:set var="weight" value="78" />
	
	<c:choose>
		<c:when test="${weight <= 70 }">
			<h4>치킨먹자!!</h4>
		</c:when>
		<c:when test="${weight <= 80 }">
			<h4>샐러드 먹자!!</h4>
		</c:when>
		<c:otherwise>
			<h4>굶어!</h4>
		</c:otherwise>
	</c:choose>

	<h2>반복문 (c:forEach)</h2><!-- 자바에서 썼던 향상된 for 문 같은 형태 -->
	<%-- for(int i=0); i < 5; i++) --%>
	<c:forEach var="i" begin="0" end="4" step="1">
		${i }
	</c:forEach>
	<hr>
	<%--16 ~ 20 --%>	
	<c:forEach var="i" begin="16" end="20" step="1" varStatus="status">
		${i }, ${status.current}, ${status.first}, ${status.last}, ${status.count} , ${status.index} 
		<br>
	</c:forEach>
	
	<hr>
	
	<%--jsp 통해 리스트 만드는 건 불가능. Controller 통해 모델로 만듦. --%>
	<%-- 일단 향상된 for 문 사용 리마인드
	
		for(String fruit : fruits) 
	--%>
	<c:forEach var="fruit" items="${fruits }" varStatus="status">
		${fruit} :::: ${status.count } ${status.index } <br>
	</c:forEach>
	
	<c:forEach var="user" items="${users }" varStatus="status">
		<h4>${status.count }번째 사람 정보</h4>
		이름 : ${user.name } 나이 : ${user.age } 취미 : ${user.hobby }
	</c:forEach>
	
	<table border="1"><!-- BS 안 써서  border 1 -->
		<thead>
			<th>번호</th>
			<th>이름</th>
			<th>나이</th>
			<th>취미</th>
		</thead>
		
		<tbody>
			<!--  
			<tr>
				<td>1</td>
				<td>김인규</td>
				<td>28</td>
				<td>댄스</td>
			</tr>
			<tr>
				<td>2</td>
				<td>김바다</td>
				<td>3</td>
				<td>잠자기</td>
			</tr>
			-->
			
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
	
	<%--
	
	
	 --%>
	
	
	
	
	
	
</body>
</html>