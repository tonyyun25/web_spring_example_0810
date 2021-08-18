package com.lytear.spring.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/lesson01/ex01")
@RestController		// @Controller + @ResponseBody
/*@RestController
@Controller + @ResponseBody가 합쳐진 어노테이션이다.
@ResponseBody를 생략해도 메소드에서 리턴된 데이터가 response body 영역에 넣어 보내진다.
API 형태로 데이터를 리턴할 경우 자주 사용한다.
참고: ResponseEntity로 리턴하기
Response의 Header 값이나 Status Code를 개발자가 세밀하게 제어할 수 있다.
https://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html*/

public class Ex01RestController {
	// 요청 url : http://localhost:8080/lesson01/ex01/3
	@RequestMapping("/3")
	public String printString () {// 해당 url이 호출됐을 때 실행되는 메소드
		return "@RestController를 통한 리턴";
	// 리턴 타입(중요)에 따라서 http Message converter가 이 타입에 맞춰서 application / json 으로 돌려줌
	}
	
	// 요청 url : http://localhost:8080/lesson01/ex01/4
	@RequestMapping("/4")
	public Map<String, String> printMap() {
		Map<String, String> map = new HashMap<>();
		map.put("김인규", "강사");
		map.put("유재석", "개그맨");
		map.put("아이유", "가수");
		
		return map;
	}
	// 요청 url : http://localhost:8080/lesson01/ex01/5
	@RequestMapping("/5")
	public Data printData() { // 메소드이름 : printData 임의로 아무렇게나 상관 없음
		Data data = new Data();
		data.setId(1);
		data.setName("김인규");
	
		return data;
	
	}
	// 요청 url : http://localhost:8080/lesson01/ex01/6
	// json 형태로도 넘기지만 이번에는 statuscode 형태로 넘길 거야 (사용자한테 컨텐츠를 에러메세지와 같이 보여주고 싶을 때)
	// 리턴 타입은 ResponseEntity에 어떤 데이터를 넘길 건지를 generic 형태로 잡아줌
	// 생성자에는 두 가지 보냄 1. 같이 실어보낼 데이터 2. Http statuscode 
	@RequestMapping("/6")
	public ResponseEntity<Data> entity() {
		Data data = new Data();
		data.setId(2);
		data.setName("유재석");
		
		// ResponseEntity 형태의 객체를 만들자
//		ResponseEntity<Data> entity = new ResponseEntity<>(data, HttpStatus.INTERNAL_SERVER_ERROR);//생성자에 실어보낼 데이터와 httpstatuscode 
		ResponseEntity<Data> entity = new ResponseEntity<>(data, HttpStatus.NOT_FOUND);// HttpStatus.OK // 구글링 http status code
		// 결과는 화면이 보이지만 사실은 에러가 난 페이지다
		// 서버에서 에러가 난 상태로 내려 줬다 => 받는 쪽에서 이 코드를 같이 받는다. internal server error = code 500
		return entity;
		
	}
	
	
	
	
}
