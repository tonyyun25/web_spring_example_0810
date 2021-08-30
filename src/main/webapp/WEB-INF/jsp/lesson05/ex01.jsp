<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Core 라이브러리</title>
<!-- 구글링 : jstl core 라이브러리에서 tag 찾아온다.
url만 추가하는게 아니라 실제 library 를 연동시켜야 한다 => build.grade에서 
implementation 'javax.servlet:jstl:1.2' 로 미리 쓸 수 있게 설정해 놓았음
 -->


</head>

<body>
	<h3>변수 사용하기 (c:set)</h3>
	
	<c:set var="number1" value="100" />
	<!-- 화면에 뿌리기. EL tag 이용해 모델에 들어있는 값 접근하듯이 똑같이 사용하면 됨.
	core 라이브러리를 통해 변수 저장하고 EL tag로 출력. 
	jstl, el tag 는 서버에서 다 처리에서 브라우저에서는 다 처리된
	html tag만 내려감 (소스보기에서 확인 가)
	 -->
	<c:set var="number2" >200</c:set> 
	 
	<h4> number1 : ${number1 }</h4>
	<h4> number2 : ${number2 }</h4>
	<!-- EL tag도 jsp 퍼센트이퀄처럼 간단한 연산 가능 -->
	<h4> number1 + number2 : ${number1 + number2 }</h4>
	<!-- 위는 EL tag를 통해 화면에 출력. 아래는 jstl를 통해 화면에 출력 -->
	<h3>변수 출력하기 (c:out) </h3>
	<h4>number : <c:out value="10" /></h4>
	<h4>number1 : <c:out value="${number1 }" /></h4>
	
	
	<!-- c:out이 아닌 형태로 출력하면 alert이 뜬다
	<script>alert('출력');</script> -->
	
	
	<!-- EL tag보다 c:out을 쓸 때 유리한 점. 나는 코드 자체를 출력하고 싶어.
	소스코드 보면 화면에 보일 수 있도록 특수한 형태의 문자로 바꿔준 것 확인 가능 -->
	
	<c:out value="<script>alert('출력');</script>" /><!-- escapeXml이 기본
	속성 값으로 true가 되어있다 -->
	<!-- c:out을 쓸 건데 alert 창을 띄워 확인하고 싶을 때 -->
	<!-- xml 취소를 false 한다, 즉 xml tag를 살려둔다 -->
	<!--<c:out value="<script>alert('뜬다');</script>" escapeXml="false" />-->
	
	<c:out value="<script>alert('출력222');</script>"  escapeXml="true" />
	
	<h2>조건문 (c:if) </h2>

	<c:if test="true">
		<h4>조건이 참이다!!</h4>
	</c:if>


	
	<!-- 변수를 통해서 사용하려면 EL tag 사용해야 한다. 간단한 연산도 가능 -->
	<c:if test="${number1 > 50 }">
	<!-- 50} "과 같이 쓰면 괄호 뒤에 공백 있으면 에러 발생. 따옴표 안에 true false 가 되는 결과로 
	조건을 확인하기 때문에 공백이 생기면 안됩니다
	-->
		<h4>number1이 50보다 크다!</h4>
	</c:if>
	
	

	<c:if test="${number1 == 50 }">
		<h4>number1이 100이다.</h4>
	</c:if>

	<c:if test="${number1 eq 200 }">
		<h4>number2는 200이다.</h4>
	</c:if>
	
	<c:if test="${number2 ne 222 }">
		<h4>number2는 222가 아니다.</h4>
	</c:if>

	
	<!--
	 모델에서 사용한 값도 EL tag에서 사용 가능.
	emtpy : null인지 또는 list 통해 내려줬는데 텅텅 비어있는지 확인 가능 
	-->
	<c:if test="${empty number3 }">
		<h4>number3이 비어있다.</h4>
	</c:if>
	
	<c:if test="${!empty number1 }">
		<h4>number1이 비어있지 않다.</h4>
	</c:if>

	
	<c:if test="${not empty number1 }">
		<h4>number1이 비어있지 않다.</h4>
	</c:if>
	
</body>
</html>