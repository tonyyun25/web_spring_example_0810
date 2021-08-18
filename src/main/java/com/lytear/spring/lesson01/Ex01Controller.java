package com.lytear.spring.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //  웹서버에 활용하겠다
// 요청이 들어오는 스프링 빈 Dispatcher Servlet에서 @Controller 들을 스캔하고,
// @RequestMapping 을 참조하여 주소의 path와 일치하는 메소드가 수행된다. Class명 위에 위치한다.
// 공통적인 부분은 클래스 위에다 RequestMapping을 추가할 수 있다. url 여기 아래로 뺄 수 있다
@RequestMapping("/lesson01/ex01")



public class Ex01Controller {

//	제일 처음 세팅한 com.lytear.spring 기본 패키지 하위에다 패키지 만들어야지 com.lytear.text 이런 식은 안 됨
//	서블릿은 클래스 단위, 스프링은 메소드 단위
	
	// Jackson Library 활용해서 json 형으로 보여줌
	
	// String 출력하기
	// 요청  URL : http://localhost:8080/lesson01/ex01/1
	
//	@RequestMapping("/lesson01/ex01/1") // 어떤 주소가 불렸을 때 수행하겠다
	@RequestMapping("/1")
	/*@RequestMapping("/경로")
	클라이언트가 요청한 URL path와 일치하는 메소드가 수행된다.
	Class명 또는 메소드명 위에 위치한다.
	Class명과 메소드명 모두 위치한 경우 /클래스명 경로/메소드명 경로가 된다.*/
	
	
	@ResponseBody // 이주소에서 만들어진 문자열이 리턴 된 그대로 보여줌
	/*아래 어노테이션이 사용되면 HttpMessageConverter가 동작하여
	메소드의 리턴값에 따라 String 또는 Json으로 변환된다.

	@ResponseBody
	컨트롤러 메소드의 리턴값이 데이터가 되어, Response 응답값의 body 영역에 넣어 보낸다.
	만약 String을 리턴한 경우 텍스트 기반 HTML 형식으로 response body에 나타난다.
	만약 Jackson 라이브러리가 설정된 경우
	컨트롤러 메소드에서 Map이 리턴되면 JSON으로 변환되어 response body에 나타난다.
	메소드명 위에 위치, 또는 메소드의 리턴값 옆에 위치*/
	
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
