package com.lytear.spring.Dlesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lytear.spring.Dlesson04.bo.SingerBO;
import com.lytear.spring.Dlesson04.model.Singer;
@RequestMapping("/lesson04")
@Controller
public class SingerController {

	
	@RequestMapping("/ex03")
	
	public String addSingerView () {
		return "lesson04/addSinger";
	}
	
	
	// Singer 추가
	@Autowired
	private SingerBO singerBO;
	
	@PostMapping("/add_singer")
	@ResponseBody
	public String addSinger(
			
			@RequestParam("name") String name
			,@RequestParam("debut") int debut
			,@RequestParam("agency") String agency
			
			
			) {
		
			int count = singerBO.addSinger(name, debut, agency);
			return "입력 성공 : " + count;
		
	}
	// 가장 최근 추가 seller 정보
	@RequestMapping("/singer_info")
	public String lastSingerInfo(Model model) {
		Singer singer = singerBO.lastSingerInfo();
		model.addAttribute("result",singer);
		model.addAttribute("subject", "가수 추가");
		return "lesson04/singerInfo";
		
	}
	
	
	
	
}
