package com.lytear.spring.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lytear.spring.lesson04.bo.NewStudentBO;
import com.lytear.spring.lesson04.model.NewStudent;

@Controller
@RequestMapping("/lesson04")
public class NewStudentController {

	
	@Autowired
	private NewStudentBO newStudentBO;
	
	@GetMapping("/ex02/1") // 기본은 Get
	public String addStudentView() {
		return "lesson04/addStudent";
	}
	
	@GetMapping("/ex02/add_student") 
	public String addStudent(
//			@RequestParam("name") String name
//			일치하는 멤버 변수의 값을 저장시키면 파라미터를 한 번에 받을 수 있다
			@ModelAttribute NewStudent newStudent//파라미터로 저장된 값, id 모두 저장된 객체임
//			파라미터 인풋 통해 집어넣으면 newStudent 객체에 값이 꽂힌다
			, Model model
			) {
		int count = newStudentBO.addStudent(newStudent);// 인서트 됐는지 먼저 검증 int count로
		
		model.addAttribute("result",newStudent);
		return "lesson04/studentInfo";
		
	}

	
	
}
