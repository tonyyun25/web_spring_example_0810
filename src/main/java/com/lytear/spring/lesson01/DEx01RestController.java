package com.lytear.spring.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lesson01/Dex01")
public class DEx01RestController {

	// 요청 url : http://localhost:8080 / lesson01 / Dex01 / 3 
	@RequestMapping("/3")
	public String printString() {
		return "@RestController를 통한 패턴";
	}
	// 요청 url : http://localhost8080:/lesson01/Dex01/4
	@RequestMapping("/4")
	public Map<String, String> printMap() {
		Map<String, String> map = new HashMap<>();
		map.put("김인규","강사");
		map.put("유재석","개그맨");
		map.put("아이유","가수");
		return map;
	}
	
	// 이번에는 map 이 아니라 우리가 만든 클래스로 리턴해 봄
	// 요청 url : http://localhost8080:/lesson01/Dex01/5
	@RequestMapping("/5")
	public Data printData() {
		Data data = new Data();
		data.setId(2);
		data.setName("유재석");
		
		return data;
		
	}
	// 요청 url : http://localhost8080/lesson01/Dex01/6
	@RequestMapping("/6")
	public ResponseEntity<Data> entity(){
		Data data = new Data();
		data.setId(1);
		data.setName("김인규");
		
		ResponseEntity<Data> entity = new ResponseEntity<>(data, HttpStatus.OK);
		
		return entity;
	}
	
	
}
