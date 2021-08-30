package com.lytear.spring.lesson04.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.lytear.spring.lesson04.model.NewUser;


@Repository
public interface NewUserDAO {
	
	
	
	public int insertUser(
			@Param("name") String name
			,@Param("yyyymmdd") String yyyymmdd
			,@Param("introduce") String introduce
			,@Param("email") String email
			);
	
	public NewUser selectLastUser();
	
	// 이제 쿼리 입장에서 리턴 타입을 고민한다. 쿼리에서 중복인지 아닌지 판단 ? 불가
	// count 함수 써서 몇 개가 저장되어 있을 지는 알 수 있다
	
	
	// name을 검색하고 그 결과 갯수를 알아온다.
	public int selectCountByName(@Param("name") String name);
	
	
}
