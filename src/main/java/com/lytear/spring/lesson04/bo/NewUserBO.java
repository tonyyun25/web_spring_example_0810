package com.lytear.spring.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lytear.spring.lesson04.dao.NewUserDAO;
import com.lytear.spring.lesson04.model.NewUser;
@Service
public class NewUserBO {

	@Autowired
	private NewUserDAO newUserDAO;
	
	public int addUser(String name, String yyyymmdd, String introduce, String email) {
		
		return newUserDAO.insertUser (name, yyyymmdd, introduce, email);
		
	}
	
	public NewUser getLastUser() {// 리턴 타입 : NewUser,파라미터 없음
		return newUserDAO.selectLastUser();
	}
	
	// 중복인지 아닌지 ? => 알려준다. BO 입장에서 리턴 타입 고민한다
	public boolean isDuplication(String name) {
		int count = newUserDAO.selectCountByName(name);
		// 일단 count에 저장하고 결과에 맞게 true 인지, false인지 밝혀 준다
		
		if(count >= 1) { // 가끔 DB에서 실수로 중복이 들어있을 수 있으므로 count == 1보다 이게 좋다
			return true;
		} else {
			return false;
		}
		
		//위 if 문을 아래와 같이 한 줄로도 할 수 있다
//		return (count >= 1);
	}
	
	
	
}
