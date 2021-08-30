<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL fn 라이브러리</title>
</head>
<body>
	<c:set var="str1" value="No pain No gain" />
	<h2>길이 구하기</h2>
	<h4>${fn:length(str1) }</h4>
	<h2>특정 문자열이 있는지 확인</h2>
	No가 있는지? ${fn:contains(str1, "No") }
	no가 있는지? ${fn:contains(str1, "no") }


	<c:if test="${fn:containsIgnoreCase(str1, 'no') }" >
	<%--${fn:containsIgnoreCase(str1, "no") } --%>
		<h4>no가 포함되어 있다!!</h4>
	</c:if>
	
	<h2>특정 문자열로 시작, 끝 나는지 확인</h2>
	<h4>No로 시작하는지? ${fn:startsWith(str1, "No") }</h4>
	<h4>gain으로 끝나는지? ${fn:endsWith(str1, "gain") }</h4>
	
	<h2>문자열 치환</h2>
	<c:set var="str2" value="I love chicken" />
	<h4>${fn:replace(str2, 'chicken', 'bread') }</h4>
	<h4>${str2 }</h4>
	<%--str2가 실제 바뀐 건 아니고 문자열을 바꾸어 리턴해 줌 --%>
	
	<h2>문자열 쪼개기</h2>
	<h4>${fn:split(str1, " ")[0] }</h4>
	<h4>${fn:split(str1, " ")[1] }</h4>
	
	<h2>문자열 자르기~</h2>
	<h4>${fn:substring(str2, 2, 6) }</h4>
	
	<h2>문자열 대소문자 변경</h2>
	
	<h4>모두 소문자로 변경 ${fn:toLowerCase(str2) }</h4>
	<h4>모두 대문자로 변경 ${fn:toUpperCase(str2) }</h4>
	
	<h2>앞뒤 공백 제거</h2>
	<c:set var="str3" value="         hello      "/>
	<!-- 공백은 pre tag안에 넣는다. 그냥 넣으면 앞뒤 공백 다 무시함 -->
	<pre>str: ${str3 }</pre>
	<pre>trim 적용 :${fn:trim(str3) }</pre>
	
	
</body>
</html>