package com.lytear.spring.lesson03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lytear.spring.lesson03.bo.ReviewBO;
import com.lytear.spring.lesson03.model.Review;

@Controller
public class ReviewController {

	
	@Autowired
	private ReviewBO reviewBO;
	
	@RequestMapping("/lesson03/ex01")// 수업에서 예제로 사용
	@ResponseBody
	public Review ex01 (
//			@RequestParam("id") int id
			/*위 한 줄은 아래 정석 표현이 생략된 것*/
//			@RequestParam(value="id", required=true) int id // 필수 파라미터 id
//			@RequestParam(value="id", required=false) Integer id // 비 필수 파라미터 id 
			/*디폴트로 지정할 수 있는 값 지정하기
			 * 값이 지정되지 않으면 디폴트 밸류인 1이 지정된다*/
			@RequestParam(value="id", defaultValue="1") int id // break 걸어서 확인 하기
			
			) { // id로 검색해서 딱 하나만 꺼내질 때.
		// id = null;
		
		// id라는 이름으로 저장된 값을 int id 변수에 저장
		// Model(Review.java) 에서 만든 객체 이름 그대로 사용
		/* 추가한 파라미터 잘 전달되는지 확인 : debugging 서버 킨 후 31행 breakpoint 걸어주기
		 * url 뒤에 http://localhost:8080//DDlesson/ex01?id=10 넣는다
		 * 파라미터는 만들어 놨지만 없을 수도 있을 떄 어떻게 관리할지?
		 * required=true가 필수 파라미터 없으면 에러 발생시키는 것
		 * required=false일 때 int(기본 자료형) id로 적으면 어떻게 처리할 지 불명확. 0 자체가 값이 될 수 있으니까
		 * Integer(객체 형태, 클래스 형태의 자료형) 형태로 세팅 하면 파라미터가 없으면 id에 null 인 상태로 들어옴
		 * */
		return reviewBO.getReview(id);
	}
	
	/*쿼리 추가할 때. 테이블 단위로 돌아감
	 * @RequestMapping("/DDlesson/ex02")// 수업에서 예제로 사용
	@ResponseBody
	public Review ex02 (
	 * 
	 * */
	
	// review에 값 insert 하기
	@RequestMapping("/lesson03/ex02")
	@ResponseBody
	public String ex02() {
	
		//storeId, menu, userName, point, review
//		int count = reviewBO.addReview(4, "콤비네이션피자", "김바다", 4.5, "할인도 많이 받고 잘 먹었습니다.");
		
		
		Review review = new Review();// Review : 테이블 칼럼이름과 멤버 변수가 일치하는 클래스
		review.setStoreId(4);
		review.setMenu("콤비네이션피자");
		review.setUserName("김바다");
		review.setPoint(4.5);
		review.setReview("할인도 많이 받고 잘 먹었습니다");
		
		int count = reviewBO.addReviewAsObject(review);
		
		return "입력 결과 : " + count;
		
	}
	//update도 select 처럼 결과를 내놓는게 아니라 insert 처럼 실행 됐냐 안 됐냐만 내놓는 거라 간단하게 @ResponseBody로
	
	// id가 23 인 리뷰 내용을 "너무너무 마싯어요"
	@RequestMapping("/lesson03/ex03")
	@ResponseBody
	public String ex03(
			@RequestParam("id") int id, 
			@RequestParam("review") String review
			
			) {
	
			int count = reviewBO.updateReviewByid(id, review);
			return "업데이트 개수 " + count; 
	}
	
	@RequestMapping("/lesson03/ex04")
	@ResponseBody
	public String ex03(
			@RequestParam("id") int id 
			) {
			int count = reviewBO.deleteReview(id);
			return "딜리트 개수 " + count;
	}
	
	
}
