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
		
		<!--  <form method="post" action="/lesson06/add_user" id="userForm">-->
		
			<label>이름</label>
			
			<div class="d-flex">
				<input type="text" name="name" class="form-control" id="nameInput">
				<button type="button" id="nameCheckBtn" class="btn btn-info">중복체크</button>
			</div>
			<label>생년월일</label><input type="text" name="yyyymmdd" class="form-control" id="yyyymmddInput">
			<label>이메일</label><input type="text" name="email" class="form-control" id="emailInput">
			<textarea rows="8" class="form-control" name="introduce" id="introduceInput"></textarea>
			<%-- form-control 클래스 쓰명 column 잡을 필요 없고 row만 잡으면 됨.
			컨트롤러는 이름 겹치면 안 됨 --%>
			
			<button type="button" class="btn btn-success" id="addBtn">추가</button>
		<!--  </form>-->
		
	</div>
	
	<script>
		$(document).ready(function(){
			// 밸리데이션 조건 넣은 다음 최초 실행시 명령 => 결과 : 입력값 없을 때 alert도 안 뜨고 입력은 성공
			//$("#addBtn").on("click",function(){
				
				
				
			/* 다른 방법 입력 : form tag O, button type=submit, form tag에 대한 이벤트로 아래와 같이 변경
			결과 : 입력 값 없으면 alert은 뜨지만 역시 입력 성공. 열심히 리턴해 줘도 submit을 중단시킬 수는 없어
			
			*/	
			//$("#userForm").on("submit",function(){
			/* 해결책 1 : 중단해야 되는 시점에 return false 해 주면 submit event가 실제로 중단이 됨
			설정 : 다른 방법 입력과 동일하고 if 문 안에 있는 return 만 return false로 변경
			결과 : submit 중단되고 추가 작동 안 함
			*/ 	
			
			/* 해결책 2: add_user로 넘긴 다음에 이 결과로 JS로 뭔가를 더 하고 싶어 혹은 이 페이지에서 인풋하고
			페이지 이동 없이 그냥 끝내고 싶은 경우 => 해당하는 submit 과정 자체를 모두 취소 (마지막에 
			return false 넣고 그 앞에 페이지 이동 없이 할 수 있는 과정을 넣는다)
			설정 : 해결책 1과 동일하고 제일 마지막에 return false만 추가
			결과 : 입력 값 추가 안 됨
			*/
			/* 해결책 3: on 함수를 통해 넘겨진 함수에는 event라고 하는 객체가 전달되는데
			event는 해당하는 이벤트 정보가 저장되어 있고 그와 관련한 메소드를 사용할 수 있게 되어 있음
			설정 : form tag O, button type=submit, function 안에 이벤트 객체 삽입. 
			e.preventDefault() 입력. return false => return, if 문 밖의 return false도 삭제
			
			e.preventDefault() 입력하면 해당하는 이벤트에 있는 속성이 싹 날라감 => submit 같은 경우
			return false 해 주지 않아도 다음으로 넘어가는 내용이 취소가 됨
			
			=> 그리고 나서 ajax를 이용해서 submit이 할 일을 내가 대신 함
			
			*/
			//$("#userForm").on("submit",function(e){
			//	e.preventDefault();
			
			/* 해결 4: AJAX 아래처럼 설정 후에는 이제는 submit을 통한 이벤트를 할 필요가 없어졌다.
			메소드, 이벤트 들에 대한 액션을 처리하는 건 JS 코드를 이용하는데 (submit 아니라)
			button 이벤트로도 할 수 있으니까
			설정 : form tag 삭제. 위 이벤트와 preventDefault 주석, button type=button, 아래 이벤트 추가
			
			*/
			$("#addBtn").on("click",function(e){
			
				
				var name=$("#nameInput").val();
				var yyyymmdd=$("#yyyymmddInput").val();
				var email=$("#emailInput").val();
				var introduce=$("#introduceInput").val().trim();
				
				if(name == null || name == "") {
					alert("이름을 입력하세요");
				
					return ;
				}

				if(yyyymmdd == null || yyyymmdd == "") {
					alert("생년월일을 입력하세요");
					
					return ;
				}
				if(email == null || email == "") {
					alert("이메일을 입력하세요");
					
					return;
				}
				if(introduce == null || introduce == "") {
					alert("자기소개를 입력하세요");
			
					return;
				}
				/*
				 Re: Javascript return false 
				2021-08-28 (토) 19:08
				
				보낸사람
				김인규<lecture@hagulu.com>
				받는사람
				윤진일<ytonyyun@naver.com>
				if 밖에서 return false 를 한것은 모든 submit 을 다 취소하겠다는 거에요. 
				그래서 아무런 수행이 되지 않는 상태가 되는 것입니다. 
				
				지금 상태의 코드라면 아무런 실행이 안되는게 맞습니다. 
				
				지금 이 상태에서 ajax를 통해서 서버에 request 를 요청하는 과정을 return false 전에 넣어 주면 
				제가 말한 페이지 이동없는 insert 가 수행이 되는거에요. 
				
				그리고 이렇게 submit 이벤트의 기능을 중단시킬 의도가 있다면, 
				
				$("#userForm").on("submit",function(e){
					e.preventDefault() 
				
				
				위처럼 해주면 return false 없이 submit 에 관련된 모든 기능을 중단 시킵니다. 
				
				
				정리하면 페이지 이동없이 서버에 rqeust 를 보내려면 ajax 를 통해서 진행되는 것입니다.
				지금 코드 상태는 단순히 submit 기능 자체를 모두 중단 시키게 하는 의도입니다. 
				
				*/
				
				
				$.ajax({
					type: "post",
					url: "/lesson06/add_user",
					data:{"name":name,"yyyymmdd":yyyymmdd,"email":email,"introduce":introduce},
					success:function(data) {
						//alert(data);
						
						// 이제 json 형태 데이타 읽는다 : result : success or fail
						if(data.result == "success") {
							alert("추가 성공");	
						} else {
							alert("추가 실패");	
						}
					},
					error:function(e){
						alert("error");
					}
				});
				
			});
				
			$("#nameCheckBtn").on("click",function()) {
				var name=$("#nameInput").val();	
				
				if(name == null || name == "") {
					alert("이름을 입력하세요");
				
					return ;
				}

				$.ajax({
					type:"get",	
					url:"/lesson06/is_duplication",
					data:{"name":name},
					success:function(data){
						// data {"isDuplication":true}
						// {"isDuplication":false}
						
						if(data.isDuplication) {
							alert("중복입니다!!");
						} else {
							alert("사용할 수 있는 이름입니다.");
						}
						
					},
					error:function(e) {
						alert("error");
					}
					
				
				});
				
			});
				
		});
	
	
	
	</script>


</body>
</html>