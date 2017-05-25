package com.yibai.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
		return new ModelAndView("login", "command", new User());
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
	public ModelAndView userlogin(@ModelAttribute("SpringWeb") User user, ModelMap model) {

		if (user.getName().equals("seller") && user.getPassword().equals("relles")) {
			return new ModelAndView("seller", "command", new Goods());

		}
		if (user.getName().equals("buyer") && user.getPassword().equals("revub")) {
			return new ModelAndView("buyer");

		}
		return new ModelAndView("404");
	}

	// 新增代码
	@RequestMapping(value = "/SellerPublish", method = RequestMethod.GET)
	public ModelAndView SellerPublish() {
		return new ModelAndView("SellerPublish", "command", new Goods());
	}

	@RequestMapping(value = "/addGoods", method = RequestMethod.POST)
	public String addSellerPublish(@ModelAttribute("SpringWeb") Goods goods, ModelMap model) {
		System.out.print(goods.toString());
		model.addAttribute("title", goods.getTitle());
		model.addAttribute("summary", goods.getSummary());
		model.addAttribute("picture", goods.getPicture());
		model.addAttribute("context", goods.getContext());
		model.addAttribute("price", goods.getPrice());

		return "result";
	}

}
