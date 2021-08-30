package com.lytear.spring.lesson06;

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
@RequestMapping("/lesson06")
public class Lesson06NewUserController {
	
	@Autowired
	private NewUserBO newUserBO; // 알아서 lesson 04 newUserBO 잡아 줌
	
	@GetMapping("/add_user_view")
	public String addUserView(
			) {
		return "lesson06/addNewUser";
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
		
		Map<String, String> result = new HashMap<>();
		
		if(count == 1) {
			result.put("result","success");
		}else {
			result.put("result","fail");
		}
		
		
		
		//return "입력 성공" + count;
		return result;
	}
	// 파라미터로 전달된 name 값이 DB에 이미 등록되어 있는지 여부 확인
	@GetMapping("/is_duplication")
	@ResponseBody
	public Map<String, Boolean> isDuplication(
			@RequestParam("name") String name
			// isDuplication 통해서 name 전달해 주면
			){
		// 아래 if 문 먼적 적고 아래 Map 적는다
		Map<String, Boolean> result = new HashMap<>();
		
		if(newUserBO.isDuplication(name)) {
			result.put("isDuplication", true);
		} else {
			result.put("isDuplication", false);
		}
		
		return result;
	}
	
	
	
}
