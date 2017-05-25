package com.yibai.springmvc;

//新增代码
public class Goods {
	private String title;
	private String summary;
	private String picture;
	private String context;
	private String price;

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

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "SellerPublish [title=" + title + ", summary=" + summary + ", picture=" + picture + ", context="
				+ context + ", price=" + price + "]";
	}

}
