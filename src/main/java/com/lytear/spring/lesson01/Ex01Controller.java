package com.lytear.spring.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //  웹서버에 활용하겠다
// 공통적인 부분은 url 여기 아래로 뺄 수 있다
@RequestMapping("/lesson01/ex01")

public class Ex01Controller {

//	제일 처음 세팅한 com.lytear.spring 기본 패키지 하위에다 패키지 만들어야지 com.lytear.text 이런 식은 안 됨
//	서블릿은 클래스 단위, 스프링은 메소드 단위
	
	// Jackson Library 활용해서 json 형으로 보여줌
	
	// String 출력하기
	// 요청  URL : http://localhost:8080/lesson01/ex01/1
	
//	@RequestMapping("/lesson01/ex01/1") // 어떤 주소가 불렸을 때 수행하겠다
	@RequestMapping("/1")
	@ResponseBody // 이주소에서 만들어진 문자열이 리턴 된 그대로 보여줌
	
	public String printString() {
		String htmlString = "예제 1번 <br> 문자열을 response body로 전달합니다";
		
		
		
		return htmlString;
		
	}
	
	// Map 출력하기
	// 요청  URL : http://localhost:8080/lesson01/ex01/2
//	@RequestMapping("/lesson01/ex01/2")
	@RequestMapping("/2")
	@ResponseBody
	public Map<String, Integer> printMap() {
//	public @ResponseBody Map<String, Integer> printMap() { 이렇게도 가능
	
		
		
		
		Map<String, Integer> map = new HashMap<>();
		// 과일과 그 가격
		map.put("apple", 1500);
		map.put("banana", 5000);
		map.put("orange", 1000);
		map.put("grape", 3000);
		
		return map;
		
	}
	
	
}
