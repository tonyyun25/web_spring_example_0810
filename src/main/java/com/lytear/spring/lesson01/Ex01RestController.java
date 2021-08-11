package com.lytear.spring.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/lesson01/ex01")
@RestController		// @Controller + @ResponseBody
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
	@RequestMapping("/6")
	public ResponseEntity<Data> entity() {
		Data data = new Data();
		data.setId(2);
		data.setName("유재석");
		
		
//		ResponseEntity<Data> entity = new ResponseEntity<>(data, HttpStatus.INTERNAL_SERVER_ERROR);//생성자에 실어보낼 데이터와 httpstatuscode 
		ResponseEntity<Data> entity = new ResponseEntity<>(data, HttpStatus.NOT_FOUND);// HttpStatus.OK // 구글링 http status 
		
		// 서버에서 에러가 난 상태로 내려 줬다 => internal server error = code 500
		return entity;
		
	}
	
	
	
	
}
