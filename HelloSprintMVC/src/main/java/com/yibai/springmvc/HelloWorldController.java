package com.yibai.springmvc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hu.demo.DBHelper;

//买家用户：buyer，密码：reyub
//卖家用户：seller，密码：relles
@Controller
public class HelloWorldController {
	@RequestMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("greeting", "Hello Spring MVC");
		return "helloworld";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		return new ModelAndView("login", "command", new OldUser());
	}

	@RequestMapping("/process")
	public String process(Model model) {
		return "pro";
	}

	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public ModelAndView student() {
		return new ModelAndView("student", "command", new Student());
	}

	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	public String addStudent(@ModelAttribute("SpringWeb") Student student, ModelMap model) {

		model.addAttribute("name", student.getName());
		model.addAttribute("age", student.getAge());
		model.addAttribute("id", student.getId());

		return "result";
	}

	@RequestMapping(value = "/userlogin", method = RequestMethod.POST)
	public ModelAndView userlogin(@ModelAttribute("SpringWeb") OldUser user, ModelMap model) {
		String sql3="select * from userlist";
		if(sql3.equals(null)){
			return new ModelAndView("register");
			//如果数据库中没有这个信息则返回注册页面
		}
		//如果有，则登录
		else{
		
		
		if (user.getUsertype().equals("seller") ) {
			return new ModelAndView("seller", "command", new Goods());

		}
		if (user.getUsertype().equals("buyer")) {
			String sql = null;
			DBHelper db1 = null;
			ResultSet ret = null;

			sql = "select *from goodslist";// SQL语句
			db1 = new DBHelper(sql);// 创建DBHelper对象

			ArrayList<Goods> dataList = new ArrayList();
			try {
				ret = db1.pst.executeQuery();// 执行语句，得到结果集
				while (ret.next()) {

					String title = ret.getString(1);
					String summary = ret.getString(2);
					String picture = ret.getString(3);
					String context = ret.getString(4);
					Integer price = ret.getInt(5);

					Goods goods = new Goods();
					goods.setTitle(title);
					goods.setSummary(summary);
					goods.setPicture(picture);
					goods.setContext(context);
					goods.setPrice(price);

					dataList.add(goods);

				} // 显示数据
				ret.close();
				db1.close();// 关闭连接
			} catch (SQLException e) {
				e.printStackTrace();
			}
			model.addAttribute("data", dataList);

			return new ModelAndView("buyer");
		}

		return new ModelAndView("404");
	}
	}
	// 新增代码
	@RequestMapping(value = "/SellerPublish", method = RequestMethod.GET)
	public ModelAndView SellerPublish() {
		return new ModelAndView("SellerPublish", "command", new Goods());
	}

	@RequestMapping(value = "/addSellerPublish", method = RequestMethod.POST)
	public String addSellerPublish(@ModelAttribute("SpringWeb") Goods goods, ModelMap model) {
		model.addAttribute("title", goods.getTitle());
		model.addAttribute("summary", goods.getSummary());
		model.addAttribute("picture", goods.getPicture());
		model.addAttribute("context", goods.getContext());
		model.addAttribute("price", goods.getPrice());

		// insert into goodslist(title, sumXXX) values ()插入数据库
		String sqlStr = "insert into goodslist(title,summary,picture,context,price) values('" + goods.getTitle() + "', "
				+ "'" + goods.getSummary() + "'," + "'" + goods.getPicture() + "'," + "'" + goods.getContext() + "',"
				+ +goods.getPrice() + ")";

		DBHelper dbHelper = new DBHelper(sqlStr);
		try {
			dbHelper.pst.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// goodsList.add(goods);
		return "result";
	}

	// 用户注册
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register() {
		return new ModelAndView("register", "command", new OldUser());
	}

	@RequestMapping(value = "/userRegister", method = RequestMethod.POST)
	public ModelAndView userRegister(@ModelAttribute("SpringWeb") OldUser user, ModelMap model) {
		String s1 = user.getName();
		String s2 = user.getPassword();
		String s3 = user.getUsertype();
		String sql = "select*from userlist where name='" + s1 + "' and password='" + s2 + "'and usertype='" + s3 + "' ";

		DBHelper db2 = null;
		ResultSet ret1 = null;

		db2 = new DBHelper(sql);// 创建DBHelper对象

		boolean result = false;
		try {
			ret1 = db2.pst.executeQuery();// 执行语句，得到结果集

			if (ret1.next()) {
				// 有结果
				result = true;
			}

			ret1.close();
			db2.close();// 关闭连接
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (result == true) {
			return new ModelAndView("login", "command", new OldUser());
		}
		if (result == false) {
			return new ModelAndView("login", "command", new OldUser());
		}
		return null;

	}
}
