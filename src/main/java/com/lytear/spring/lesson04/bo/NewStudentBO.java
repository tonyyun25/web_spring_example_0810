package com.lytear.spring.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lytear.spring.lesson04.dao.NewStudentDAO;
import com.lytear.spring.lesson04.model.NewStudent;

@Service
public class NewStudentBO {
	@Autowired
	private NewStudentDAO newStudentDAO;
	
	public int addStudent(
			// 인서트 1) 필드로 인서트 2) object로 인서트. 여기선 2번
			NewStudent student
			) { // 인서트니깐 리턴타입은 int
		return newStudentDAO.insertStudent(student);
		
	}
	
}
