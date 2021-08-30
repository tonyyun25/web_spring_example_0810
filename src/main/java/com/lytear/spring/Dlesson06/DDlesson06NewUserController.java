package com.lytear.spring.Dlesson06;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lytear.spring.lesson04.bo.NewUserBO;

@Controller
@RequestMapping("/DDlesson06")
public class DDlesson06NewUserController {
	@Autowired
	private NewUserBO newUserBO; // 알아서 lesson 04 newUserBO 잡아 줌
	
	@GetMapping("/add_user_view")
	public String addUserView(
			) {
		return "lesson06/DDaddNewUser";
	}
	
	@PostMapping("/add_user")
	@ResponseBody//리턴된 문구로 jsp body를 찾는다
//	public String addUser( // Map으로 하려다 입력 상황만 확인하도록 String으로 타입 잡음
	public Map<String, String> addUser(
			
			@RequestParam("name") String name
			,@RequestParam("yyyymmdd") String yyyymmdd
			,@RequestParam("email") String email
			,@RequestParam("introduce") String introduce
			
			) {
		int count = newUserBO.addUser(name, yyyymmdd, introduce, email);
		
		Map<String, String> result = new HashMap<>(); // 성공 여부를 이 맵에다 저장한다
		
		if(count == 1) {
			result.put("result","success");
		} else {
			result.put("result","fail");
		} // HTTP message converter 통해 Json으로 변환된다
		
		
		
//		return "입력 성공" + count;
		return result;
	}
}
