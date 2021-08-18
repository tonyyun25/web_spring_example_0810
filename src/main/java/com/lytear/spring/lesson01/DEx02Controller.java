package com.lytear.spring.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DEx02Controller {
	// 요청 url : http://localhost8080:lesson01/Dex02/1 
	@RequestMapping("/lesson01/Dex02/1")
	
	public String view() {
		
		return "lesson01/Dex02";
	}
	
	
	
	
	
	
	
	
	
	
}
