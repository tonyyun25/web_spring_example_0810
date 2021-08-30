package com.lytear.spring.Dlesson04.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.lytear.spring.Dlesson04.model.Singer;

@Repository
public interface SingerDAO {

	public int insertSinger (
			@Param("name") String name
			,@Param("debut") int debut
			,@Param("agency") String agency
			
			);
	
	
	public Singer lastSingerView ();
	
	
}
