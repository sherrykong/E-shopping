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
			return new ModelAndView("seller", "command", new SellerPublish());
		}
		if (user.getName().equals("buyer") && user.getPassword().equals("revub")) {
			return null;
		}
		return null;
	}

	// 新增代码
	@RequestMapping(value = "/SellerPublish", method = RequestMethod.GET)
	public ModelAndView SellerPublish() {
		return new ModelAndView("SellerPublish", "command", new SellerPublish());
	}

	@RequestMapping(value = "/addSellerPublish", method = RequestMethod.POST)
	public String addSellerPublish(@ModelAttribute("SpringWeb") SellerPublish SellerPublish, ModelMap model) {

		model.addAttribute("title", SellerPublish.getTitle());
		model.addAttribute("summary", SellerPublish.getSummary());
		model.addAttribute("picture", SellerPublish.getPicture());
		model.addAttribute("context", SellerPublish.getContext());
		model.addAttribute("price", SellerPublish.getPrice());

		return "result";
	}

}
