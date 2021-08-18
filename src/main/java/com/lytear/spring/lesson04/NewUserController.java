package com.lytear.spring.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lytear.spring.lesson04.bo.NewUserBO;
import com.lytear.spring.lesson04.model.NewUser;

@RequestMapping("/lesson04")
@Controller
public class NewUserController {
	@RequestMapping("/ex01/1")
	public String addUserView() {
		return "lesson04/addUser";
	}
	
	@Autowired
	private NewUserBO newUserBO;
	
//	@RequestMapping("/ex01/add_user")
//	@RequestMapping(method=RequestMethod.POST, path= "/ex01/add_user")
	@PostMapping("/ex01/add_user")// 내용이 기니까 post
	@ResponseBody
	public String adduser(
			@RequestParam("name") String name
			,@RequestParam("yyyymmdd") String yyyymmdd
			,@RequestParam("introduce") String introduce
			,@RequestParam("email") String email
			) {
		
//		명확하게 나는 get 또는 post 로만 받고 싶어 정의하는 법 : requestMapping에 속성 추가
		int count = newUserBO.adduser(name, yyyymmdd, introduce, email);
		return "입력 성공 : " + count;
		
		
		
	}
	
	// 가장 최근에 등록한 사용자 정보 출력
	@GetMapping("/ex01/2")//select 한 결과니까 get
	@ResponseBody // 우리가 기존에 해 왔던 select 한  다음에  html에 연결
	// 임시로 ResponseBody로 하고 있고 아직 jsp 연동 안 함
	public NewUser lastUser() {
		
		return newUserBO.getLastUser();
		
	}
	
	
	
	
}
