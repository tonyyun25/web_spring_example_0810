package com.lytear.spring.lesson03.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.lytear.spring.lesson03.model.Review;

@Repository
public interface ReviewDAO {

	
	public Review selectReview(@Param("id") int id);
	
	public int insertReview(
			@Param("storeId") int storeId,
			@Param("menu") String menu,
			@Param("userName") String userName,
			@Param("point") double point,
			@Param("review") String review
			);
	
	
	
	public int insertReviewAsObject (Review review);

	public int updateReviewByid (
			@Param("id") int id,
			@Param("review") String review
			
			);
	
	
	public int deleteReview(
			@Param("id") int id
			);
	
	
	
	
}
