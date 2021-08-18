package com.lytear.spring.lesson02.model;

import java.util.Date;

public class UsedGoods {

	/* Entity 또는 DTO 같은 데이터를 전달하기 위한 클래스들은 또다른 패키지에 만들거야
	 * 여기에서 중요한 건 해당하는 컬럼 이름과 클래스 안에 있는 멤버 변수 이름을 똑같이 일치시키는 것이 중요
	 * 
	 * 
	 * */
	
	private int id;
	private String title; 
	private int price;
	private String description;
	private String picture;
	private int sellerId;
	private Date createdAt;
	private Date updatedAt;
	// 이 클래스를 알아서 누군가에게 생성시켜 달라고 하고 그 안에 값도 넣어달라고 할 거야 우리가 직접 안 하고
	// 이 클래스 안에 직접 내용 생성해 줘 요청하려면 getter setter 필요
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public int getSellerId() {
		return sellerId;
	}
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
	
}
