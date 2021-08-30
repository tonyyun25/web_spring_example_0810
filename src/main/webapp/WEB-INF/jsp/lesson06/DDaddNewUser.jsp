<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 추가</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<%-- AJAX를 사용하려면 더 많은 함수가 있는 js를 포함해야 한다. 앞축 안 된 건 소스를 보는 것이므로 min 버전 --%>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<!--  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>-->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    


</head>
<body>
	<div class="container">
		<h1>회원 정보 추가</h1>	
		<!--
		 submit 장점 : 입력하고 싶을 때 내가 엔터키를 누르면 입력이 됨.
		 일반적으로 추가하는 과정은 엔터하지 않죠, 도리어 방해가 되
		 클릭이벤트는 엔터 쳐도 무반응.
		 로그인 시(id, pw 기계적)는 form tag, event.Default로 이벤트 다 날려버리고
		 ajax 활용해서 해 주면 좋아
		-->
		
		
		<!-- <form method="post" action="/lesson06/add_user" id="userForm"> -->
			<label>이름</label><input type="text" name="name" class="form-control" id="nameInput">
			<label>생년월일</label><input type="text" name="yyyymmdd" class="form-control" id="yyyymmddInput">
			<label>이메일</label><input type="text" name="email" class="form-control" id="emailInput">
			<textarea rows="8" class="form-control" name="introduce" id="introduceInput"></textarea>
			<%-- form-control 클래스 쓰명 column 잡을 필요 없고 row만 잡으면 됨.
			컨트롤러는 이름 겹치면 안 됨 --%>
			
			<button type="button" class="btn btn-success" id="addBtn">추가</button>
		<!--  </form>-->	
	</div>
	<%--click event로 vali 했지만 form 통한 submit도 같이 동작해 버림
	. 이미 다른 페이지로 이동해버림. 페이지가 이동하면 여기 있는 javascript 내용은 아무 의미가 없어짐
	form을 기반으로 만들어진 버튼 클릭으로는 vali 할 수 없음
	방법 1. 버튼 이벤트가 아니라 form에 대한 이벤트를 잡아준다 =>  form에도 id 추가. 클릭 아니고 submit 이벤트
	       return false 설정
	방법 2. 페이지 이동 안 하고 여기에서 끝내는 방법 => 해당 submit 과정 모두 취소시킨다
		 	무조건 return false를 제일 아래에 준다
			JS에서 이벤트 들어왔을 떄 이벤트가 가진 특성을 모두 날릴 수도 있다
	 --%>
	<script>
		$(document).ready(function(){
			<!-- $("#addBtn").on("click",function(){-->
			<!--$("#userForm").on("submit",function(){	-->
			<!--방법2. 이벤트 특성을 날린다. on 함수를 통해 넘겨진 function에는 event라는 객체가 전달됨
			e에는 해당 이벤트 정보와 그와 관련된 메소드를 사용할 수 있게 되어 있음
			-->	
			// $("#userForm").on("submit",function(e){	
			$("#addBtn").on("click",function(e){
				//addBtn 통한 이벤트야, submit 아니에요, 즉 form(tag) 자체가 필요없다는 의미
				//이거 추가하고 이게 form 문 날리고, button type을 input에서 button으로 바꿈
			
				<!--e.preventDefault();[ 이거는 submit 하고 같이 움직인다.
					이거 해 주면 if 문마다
					return false 해 주지 않아도 다음(화면)으로 넘어가는 기능이 다 취소가 된다] form tag 없애면서 삭제-->
				<!--return false 안 해도
				다음으로 가능 과정 다 취소되 버린다. submit 고유 속성 다 날림-->
				<!--alert("submit 이벤트");-->
				var name=$("#nameInput").val();
				var yyyymmdd=$("#yyyymmddInput").val();
				var email=$("#emailInput").val();
				var introduce=$("#introduceInput").val().trim();
				
				if(name == null || name == "") {
					alert("이름을 입력하세요");
					<!--return false;
					명확하게 return false 해 주면 submit 이벤트가 실제로 중단이 됨-->
					return ;
				}

				if(yyyymmdd == null || yyyymmdd == "") {
					alert("생년월일을 입력하세요");
					<!--return false;-->
					return ;
				}
				if(email == null || email == "") {
					alert("이메일을 입력하세요");
					<!--return false;-->
					return ;
				}
				if(introduce == null || introduce == "") {
					alert("자기소개를 입력하세요");
					<!--return false;-->
					return ;
				}
				<!--방법2 에서 추가
				return false; 이거 한 줄 쓸 수도 있고 위에서 e 객체 활용하는 방법도 있음
				이렇게 제일 아래에 적으면 그 위에다 페이지 이동 없이 처리 할 수 있는 것들 적을 수 있음
				.
				ajax 통해서 페이지 이동 없이 내부적으로 js 통해서만(request, response 다 해결) 통신하게 됨
				로그인 할 경우에는 버튼에 대한 이벤트 필요 없게, form event 통해 날려주고 ajax 해 주면 좋아
				-->	
				$.ajax({
					type:"post",	
					url:"/Dlesson06/add_user",
					data:{"name":name,"yyyymmdd":yyyymmdd,"email":email,"introduce":introduce},
				<!--data:앞의 "name": input의 name=""와 같음, 서버에서 받을 파라미터 이름.
					뒤의 name:실제로 사용자가 입력한 값을 저장한 변수-->
					<!--★ success: 성공했을 떄 실행 내용을 등록-->
					success:function(data){<!--response로 전달된 데이터--> 
						<!--alert(data);전달된 데이타가 입력성공 1.-->
						
						/* result : success or fail. Controller에 pass, fail 설정 후 아래 추가.
						=> 아까 처럼 그대로 나오는 게 아니고 (입력성공 1) 전달 받은 데이터를 가지고 JS 
						객체 형태로 다루면서 우리가 원하는 형태로 보여주고 페이지 이동도 없음 : 
							이게 AJAX를 쓰는 이유 . JS 통해 모든 걸 통제*/
							if(data.result == "success") {//data안에 result 안에 들어있는 값 확인
								alert("추가 성공");
							} else {
								alert("추가 실패");
							}
								
						},
						error:function(e){
							alert("error");
						}
					});
				<!--이제 submit action이 필요 없어졌다 -->
				
			});
		});
	
	
	
	</script>


</body>
</html>