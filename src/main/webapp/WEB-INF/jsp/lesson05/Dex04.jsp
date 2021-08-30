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

	No가 있는지? ${fn:contains(str1, "No") }
	no가 있는지? ${fn:contains(str1, "no") }
	<c:if test="${fn:containsIgnoreCase(str1, 'no')}">
		<h4>no가 포함</h4>
	</c:if>
	
	<h4>${fn:startsWith(str1, "No") }</h4>
	<h4>${fn:endsWith(str1, "gain") }</h4>
	
	<c:set var="str2" value="I love chicken" />
	<h4>${fn:replace(str2, 'chicken','bread') }</h4>
	<h4>${str2 }</h4>
	
	<h4>${fn:split(str1, " ")[0] }</h4>
	<h4>${fn:split(str1, " ")[1] }</h4>
	
	<h4>${fn:substring(str2, 2, 6) }</h4>
	
	<h4>${fn:toLowerCase(str2) }</h4>
	
	<h4>${fn:toUpperCase(str2) }</h4>
	
	<c:set var="str3" value="               hello          " />
	<pre>str: ${str3 }</pre>
	<pre>${fn:trim (str3) }</pre>
	
</body>
</html>