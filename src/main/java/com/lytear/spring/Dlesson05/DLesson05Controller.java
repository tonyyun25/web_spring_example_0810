package com.lytear.spring.Dlesson05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/Dlesson05")
@Controller
public class DLesson05Controller {
	
	/*
	 * 1. This application has no explicit mapping for
	 *  /error, so you are seeing this as a fallback.
	 * : 
	 * 
	 * 
	 * 
	 * */
	@GetMapping("/Dex01")
	public String Dex01() {
		return "lesson05/Dex01";
	}
	
	@GetMapping("/Dex02")
	public String Dex02(Model model) {
		
		List<String> fruits = new ArrayList<>();
		fruits.add("수박");
		fruits.add("딸기");
		fruits.add("포도");
			
		model.addAttribute("fruits",fruits);
		
		
		
		
		
		List<Map<String, Object>> users = new ArrayList<>();
		
		
		Map<String, Object> map = new HashMap<>();
		map.put("name", "둘리");
		map.put("age", 7);
		map.put("hobby", "날기");
		users.add(map);
		
		map = new HashMap<>();
		map.put("name", "고길동");
		map.put("age", 47);
		map.put("hobby", "화내기");
		users.add(map);
		
		model.addAttribute("users",users);
		
		return "lesson05/Dex02";
	}
	
	@GetMapping("/Dex04")
	public String Dex04() {
		return "lesson05/Dex04";
	}
	
	
	
}
