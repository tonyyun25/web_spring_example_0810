package com.lytear.spring.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lytear.spring.lesson02.dao.UsedGoodsDAO;
import com.lytear.spring.lesson02.model.UsedGoods;

@Service // Service 이기 때문에 annotation 붙여 줌
public class UsedGoodsBO {

	/* BO : busines object. business layer, service를 의미
	 * 컨트롤러로부터 데이터를 받아서 business logic을 처리할 녀석
	* 컨트롤러가 business logic을 통해서 뭔가를 수행하려면 controller가 호출할 메소드가 있어야 한다
	* 
	* 얘가 할 일은 DAO(모델) 쪽에 실제 쿼리를 날려서 수행을 해 달라고 시켜야 함, 직접 (수행) 하지 않고
	* 얘가 원하는 것을 business layer한테 시킬 거라 결과를 가져와야 한다. 따라서 list<usedGoods>
	* 얘가 직접하지 않고 spring 기본 구조 따라가 => BO가 호출할 repository를 새로운 패키지  dao 만든다
	* 
	*
	*Mapper 까지 다 끝내고 다시 돌아와 아래 두 줄 작성
	*/
	@Autowired /*키워드. 그 다음 멤버 변수 만들듯이 DAO를 멤버변수로 만든다
	Spring은 직접 객체를 만들어서 DAO를 호출하지 않고 Autowired를 사용*/
	private UsedGoodsDAO usedGoodsDAO;
	
	public List<UsedGoods> getUsedGoodsList() {// 컨트롤러가 지금 원하는 게 list로 된 UsedGoods
		return usedGoodsDAO.selectUsedGoodsList();// selectUsedGoodsList():DAO 메소드
		
//		Autowired 두 줄 만들고 나면 객체 생성하지 않아도 usedGoodsDAO와 같이 바로 사용할 수 있다
		
//		컨트롤러가 직접 처리하지 않고 business layer 를 만들고 컨트롤러가 호출할 수 있도록 메소드를 만든다
//		 business layer에서도 직접 DB 쿼리를 할 수 없고 repository를 통해서 함 -> DAO 만듦
//		
//		
//		repository에서 controller로 바로 갈 수 없고 BO를 거쳐야 갈 수 있다
//		필요한 라이브러리는 gradle 통해 이미 세팅해 놨어. servlet에서  DB 주소, 접속해라 메소드수행
//		이 있었는데 여기서도 그런 내용 수행
		
		
	}
	
	
	
}
