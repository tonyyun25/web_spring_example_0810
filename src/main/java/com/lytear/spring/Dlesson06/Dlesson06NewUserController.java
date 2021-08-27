package com.lytear.spring.Dlesson06;

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
	public String addUser(
			@RequestParam("name") String name
			,@RequestParam("yyyymmdd") String yyyymmdd
			,@RequestParam("email") String email
			,@RequestParam("introduce") String introduce
			) {
	
		int count = newUserBO.addUser(name, yyyymmdd, introduce, email);
		return "입력성공 " + count;
	}
	
	
}
