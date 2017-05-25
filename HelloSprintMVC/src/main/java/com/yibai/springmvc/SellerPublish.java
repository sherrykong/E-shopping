package com.yibai.springmvc;

import java.awt.Image;

public class SellerPublish {
private String title;
private String summary;
private Image picture;
private String context;
private Integer price;

public void setTitle(String title) {
	this.title = title;
}

public String getTitle() {
	return title;
}
	
public void setSummary(String summary) {
	this.summary = summary;
}

public String getSummary() {
	return summary;
}	
public void setPicture(Image picture) {
	this.picture = picture;
}

public Image getPicture() {
	return picture;
}	
public void setContext(String context) {
	this.context = context;
}

public String getContext() {
	return context;
}
public void setPrice(Integer price) {
	this.price = price;
}

public Integer getPrice() {
	return price;
}
	
	
}
