package com.lytear.spring.lesson03.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lytear.spring.lesson03.dao.ReviewDAO;
import com.lytear.spring.lesson03.model.Review;

@Service
public class ReviewBO {

	
	@Autowired
	private ReviewDAO reviewDAO;
	
//	public Review getReview() {
	public Review getReview(int id) {
				
				
		return reviewDAO.selectReview(id);
	}
	
	// add reiview
	
	//storeId, menu, userName, point, review
	public int addReview(int storeId, String menu, String userName, double point, String review) {
		return reviewDAO.insertReview(storeId, menu, userName, point, review);
		
		
	}
	
	public int addReviewAsObject(Review review) { // 리턴하는 int는 실행 결과를 의미
	// object: 클래스를 기반으로 만들어진 객체를 사용. 위 요소들이 다 들어있는 클래스 객체를 받음
		return reviewDAO.insertReviewAsObject(review);
		
	}
	
	public int updateReviewByid(int id, String review) {
		return reviewDAO.updateReviewByid (id, review);
	}
	
	public int deleteReview(int id) {
		return reviewDAO.deleteReview(id);
	}
	
	
}
