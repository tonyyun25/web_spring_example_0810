package com.lytear.spring.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
// 이제는 Spring에서 jsp를 쓸 준비가 되었는데 jsp를 막 가져다 쓰지 않고 conroller를 통해서 이용할 거야
// 이제 우리는 View를 사용할 때 jsp를 연동할 때는 responseBody 사용 안 하므로 Restcontroller 쓰면 안 됨
@Controller
public class Ex02Controller {
	// 요청 url: http::/localhost:8080/lesson01/ex02/1
	@RequestMapping("/lesson01/ex02/1")
	public String view() { // 간단한 jsp를 만들고 jsp 경로를 string 형태로 리턴
		
		return "lesson01/ex02";// 경로만 잡아주면 jsp 볼 수 있음. slash는 application.properties에서 미리 붙여놨어
	}
	
	/* 서버 껐다 켜는 방법과 서버 포트 두 개 다르게 설정하는 두 가지
	 * 방법 있음. 서버 포스 SpringTest에 다르게 설정하려면 
	 * application properties에 아래 추가하면 됨
	 * server.port=8888
	 * 선생님은 url에 포트 입력 귀찮아 껐다 켜고 있음
	 * 
	 * 예전에는 jsp 로 끝나는 직접 jsp파일로 접근하는 사이트도 있었는데 요즘에는 그런 사이트 있으면 욕먹음
	 * .login 형태만 있음 
	*/
	
	
}
