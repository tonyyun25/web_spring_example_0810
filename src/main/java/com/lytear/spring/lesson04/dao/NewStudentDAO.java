package com.lytear.spring.lesson04.dao;

import org.springframework.stereotype.Repository;

import com.lytear.spring.lesson04.model.NewStudent;

@Repository
public interface NewStudentDAO {

	
	public int insertStudent(NewStudent newStudent);//requestParam에서 객체로 받은 것과
	// DAO에서 객체 받는 것은 연관 X. insertQuery에서 id 받는 것은 DAO에서 객체를 받는 것에 한정
	
}
