package com.yibai.springmvc;

<<<<<<< HEAD
import java.awt.Image;

=======
>>>>>>> ca6f13e79044527197015c4ae94b63811ce12f58
//新增代码
public class Goods {
	private String title;
	private String summary;
	private String picture;
	private String context;
<<<<<<< HEAD
	private Integer price;
=======
	private String price;
>>>>>>> ca6f13e79044527197015c4ae94b63811ce12f58

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

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getPicture() {
		return picture;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getContext() {
		return context;
	}

<<<<<<< HEAD
	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getPrice() {
=======
	public void setPrice(String price) {
		this.price = price;
	}

	public String getPrice() {
>>>>>>> ca6f13e79044527197015c4ae94b63811ce12f58
		return price;
	}

	@Override
	public String toString() {
<<<<<<< HEAD
		return "Goods [title=" + title + ", summary=" + summary + ", picture=" + picture + ", context=" + context
				+ ", price=" + price + "]";
=======
		return "SellerPublish [title=" + title + ", summary=" + summary + ", picture=" + picture + ", context="
				+ context + ", price=" + price + "]";
>>>>>>> ca6f13e79044527197015c4ae94b63811ce12f58
	}

}
