package com.lytear.spring.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/lesson01/Dex01")
public class DEx01Controller {

	// 요청 URL : http://localhost:8080/lesson01/Dex01/1
	
	@RequestMapping("/1")
	@ResponseBody
	
	public String printString() {
		String htmlString = "예제 1번 <br> 문자열을 response body로 전달합니다";
		
		return htmlString;
	}
	// 요청 URL : http://localhost:8080/lesson01/Dex01/2
		
	@RequestMapping("/2")
	@ResponseBody
	public Map<String, Integer> printMap() {
		Map<String, Integer> map = new HashMap<>();
		map.put("apple",1500);
		map.put("banana",5000);
		map.put("orange",1000);
		map.put("grape",3000);
		return map;
	}
	
	
}
