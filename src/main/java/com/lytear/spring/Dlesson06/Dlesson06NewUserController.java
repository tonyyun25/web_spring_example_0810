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
@RequestMapping("/Dlesson06")
public class Dlesson06NewUserController {

	@Autowired
	private NewUserBO newUserBO;
	
	@GetMapping("/add_user_view")
	public String addUserView() {
		return "lesson06/DaddNewUser";
	}
	
	@PostMapping("/add_user")
	@ResponseBody
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
		}else {
			result.put("result","fail");
		}
		
		
		return result;
		
		
	}
	/*
	 * 아작스는 화면 아닌 데이터를 주고받는다. JS에서 사용하기 편리한 데이터 형태 : json => map 형태로 내려 보자
	 * */
	
}
