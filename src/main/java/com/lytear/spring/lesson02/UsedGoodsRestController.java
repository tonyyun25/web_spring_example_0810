package com.lytear.spring.lesson02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lytear.spring.lesson02.bo.UsedGoodsBO;
import com.lytear.spring.lesson02.model.UsedGoods;

@RestController // 세팅하면 ResponseBody 기본으로 사용 가능
public class UsedGoodsRestController {

	/* 먼저 제일 중요한 건 Controller를 만드는 일
	 * 파일 만드는 순서 : Controller -> UsedGoods entity -> bo (Service) -> bo가
	 *                호출할 Repository (DAO, 모델부분) -> xml (쿼리 수행) 
	 * 지금은 단순화하기 위해 view 에 연결하지 않고 Restcontroller 활용
	SELECT * FROM `used_goods`
	Controller 제일 중요한 건 url mapping
	
	Controller는 request, response 반응과 밀접한 관련
	
	Entity : Data 멤버가 가지고 있는 칼럼 이름을 멤버 변수로 가져간 클래스
	
	
	*/
	
	@Autowired/* BO에서 Autowired 두 줄 만들고 돌아와 여기에도 두 줄 추가. 그 다음 맨 아래 줄*/
	private UsedGoodsBO usedGoodsBO;
	
	// 	SELECT * FROM `used_goods`
	
	@RequestMapping("/lesson02/ex01")
	public List<UsedGoods> ex01() {// UsedGoods 형태의 json map 형태의 json 내용이
		// 리스트안에 포함되어서 전달됨. 메소드 이름은 임의로 ex01()로 지음
//	ResponseBody 형태로 갈 거라서 Http message converter를 통해서 객체를 json으로 변환하도록 만들며,
//	변환할 때 그 리턴 타입을 잘 잡아줘야 함	
//	List 정하고 <> 안에는 이제 구조적으로 명확히 하기 위해서 entity 클래스 만들거야 	
//	Entity는 DB가 가지고 있는 칼럼 이름을 멤버 변수로 가지는 클래스
		
//		리턴할 타입이 정해졌으니 하나씩 채워나간다
	// 리턴 타입을 used goods의 내용을 돌려줘야 하기 때문에 그 클래스?와 같은 타입으로 만들어준다
//	우리가 원하는 데이터를 바로 접근하는 것이 아니라 business layer라고 하는 service를 통해서 한다	
//		컨트롤러가 호출할 수 있도록 메소드 만드는데. BO에서 dao에 있는 데이터 호출해야 하니
//		dao에서 메소드 만든다
		
		// Autowired 두 줄 만들고 나면 객체 생성할 필요 없이 아래처럼 바로 쓰면(호출) 됨
		// 컨트롤 누르면 이동
		return usedGoodsBO.getUsedGoodsList();
		/* BO 에서 리턴된 결과가 컨트롤러로 오고 컨트롤러는 그 결과를 리턴함
		 * 리턴하면 RestController 만들어 놨기 때문에 ResponseBody를 통해서 해당 List<UsedGoods>가
		 * json으로 바뀌어서 사용자 Browser로 response로 넘어가게 됨
		 * 
		 * 
		 * */
		
	}
	
}
