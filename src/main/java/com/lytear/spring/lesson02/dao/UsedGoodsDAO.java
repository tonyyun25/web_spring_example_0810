package com.lytear.spring.lesson02.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lytear.spring.lesson02.model.UsedGoods;

@Repository//얘는 모델을 관리하는 놈
public interface UsedGoodsDAO {
/* 인터페이스는 클래스와 비슷한 형태를 가지지만 멤버 변수 없고 메소드를 정의는 하지만 실행 부분은 없음
 * 인터페이스를 만들면 그걸 실행하는 진짜 클래스가 있어야 의미가 있음
 * 
 * 구현부가 없어 쿼리 수행은 이것을 상속 받은, implement 하는 클래스에서 만들지 않고 xml을 통해서 구현
 * srl.main.resources에 xml 저장
 * usedGoods"Mapper" 약속처럼 붙일 키워드
 * 
 * DAO에서 직접 쿼리를 날리지 못하므로 Java 코드 형태로 xml에서 쿼리 수행할 수 있게 해 줌
 * 
 * BO에서 DAO를 호출하기 위한 메소드를 만듦 */
	public List<UsedGoods> selectUsedGoodsList();//인터페이스라 구현부가 없어
	// 위 메소드대로 xml에서 쿼리를 수행하고 결과를 돌려줌 -> business layer에서 메소드 호출해서
	// 돌려받음
	
	
}
