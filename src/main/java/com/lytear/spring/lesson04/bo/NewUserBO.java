package com.lytear.spring.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lytear.spring.lesson04.dao.NewUserDAO;
import com.lytear.spring.lesson04.model.NewUser;

@Service
public class NewUserBO {

	@Autowired
	private NewUserDAO newUserDAO;
	
	public int adduser(String name, String yyyymmdd, String introduce, String email) {
		
		return newUserDAO.insertUser (name, yyyymmdd, introduce, email);
		
	}
	
	public NewUser getLastUser() {// 리턴 타입 : NewUser,파라미터 없음
		return newUserDAO.selectLastUser();
	}
	
	
}
