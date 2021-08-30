package com.lytear.spring.Dlesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lytear.spring.Dlesson04.dao.SingerDAO;
import com.lytear.spring.Dlesson04.model.Singer;

@Service
public class SingerBO {

	@Autowired
	private SingerDAO singerDAO;
	
	public int addSinger (String name, int debut, String agency) {
		return singerDAO.insertSinger(name, debut, agency);
	}
	
	public Singer lastSingerInfo() {
		return singerDAO.lastSingerView();
		
	}
	
	
	
	
	
}
