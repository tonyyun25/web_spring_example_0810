package com.lytear.spring.lesson05;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/lesson05")
@Controller
public class Lesson05Controller {

	@GetMapping("/ex01")
	public String ex01() {
		// 접근할 jsp 경로 직접 잡아준다
		return "lesson05/ex01";
		
		
	}
	@GetMapping("/ex02")
	public String ex02(Model model) {
		// 과일 이름을 저장하고 있는 리스트
		List<String> fruits = new ArrayList<>();
		fruits.add("수박");
		fruits.add("딸기");
		fruits.add("포도");
		
		model.addAttribute("fruits", fruits);
		
		// List<Map>
		// [ {name:"김인규", age:28, hobby:"댄스"}, ....]
		
		List<Map<String, Object>> users = new ArrayList<>();
		
		Map<String, Object> map = new HashMap<>();
		map.put("name", "김인규");
		map.put("age", 28);
		map.put("hobby", "댄스");
		users.add(map);
		
		map = new HashMap<>();
		map.put("name", "김바다");
		map.put("age", 3);
		map.put("hobby", "사냥하기");
		users.add(map);
		
		model.addAttribute("users", users);
		
		return "lesson05/ex02";
		
	}
	
	@GetMapping("/ex03")
	public String ex03(Model model) {
		
		Date today = new Date();//이 객체 생성 시간 정보 저장
		model.addAttribute("today",today);
		
		
		return "lesson05/ex03";
		
		
	}
	
	@GetMapping("/ex04")
	public String ex04() {
		return "lesson05/ex04";
	}
	
	
	/*
	 * 요즘은 java 문법 아니라 tag 형태로 들어가는게 html 문법에 더 가깝다고 생각함 => jstl 문법
	 * %@ : 뭔가 선언적인 것. ex) import. 여기서는 tag library 추가할 때 사용
	 * uri : 얘가 (c라는 prefix를 가지고) 사용하게 될 core library를 이 주소를 통해 가져오겠다
	 * 함수 : substring , startswith 등
	 * 
	 * c : pre fix (core library)
	 * set : 변수를 사용해 어떤 기능을 쓸 건지
	 * var : 내가 저장할 변수
	 * value : 내가 저장할 값
	 * 
	 * EL tag 통해 통해 모델(Controller)에 저장된 데이터 뿐 아니라 core library 데이타도 가져 옴
	 * 
	 * 닫는 tag가 따로 없을 때는 / 붙이고, 있을 때는 안 붙여도 됨
	 * 
	 * 
	 * 조건문
	 * test 속성 : 뒤에 따옴표 안에 넣는다. 조건은 EL tag로 묶어서 만든다
	 * 결과가 true 면 중간에 tag로 감싼 내용이 표시됨
	 * 
	 * empty 변수 이름 : 변수 값이 null 인지 아닌지 판단
	 * 
	 * 
	 * JSP를 통해 대부분 진행 되겠지만 JSP를 부르려면 controller가 필요
	 * 
	 * 
	 * 
	 * =========  if else   ========
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */
}
