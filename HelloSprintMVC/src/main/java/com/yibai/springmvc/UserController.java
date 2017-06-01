package com.yibai.springmvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	   public ModelAndView user() {
	      User user = new User();      
	      user.setFavoriteFrameworks((new String []{"Spring MVC","Struts 2"}));
	      ModelAndView modelAndView = new ModelAndView("user", "command", user);
	      return modelAndView;
	   }

	   @RequestMapping(value = "/addUser", method = RequestMethod.POST)
	   public String addUser(@ModelAttribute("SpringWeb")User user, 
	      ModelMap model) {
	      model.addAttribute("username", user.getUsername());
	      model.addAttribute("password", user.getPassword());
	      model.addAttribute("address", user.getAddress());
	      model.addAttribute("receivePaper", user.isReceivePaper());
	      model.addAttribute("favoriteFrameworks", user.getFavoriteFrameworks());
	      return "userlist";
	   }

	   @ModelAttribute("webFrameworkList")
	   public List<String> getWebFrameworkList()
	   {
	      List<String> webFrameworkList = new ArrayList<String>();
	      webFrameworkList.add("Spring MVC");
	      webFrameworkList.add("Spring Boot");
	      webFrameworkList.add("Struts 2");
	      webFrameworkList.add("Apache Hadoop");
	      return webFrameworkList;
	   }
}
