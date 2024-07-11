package com.admin.controllers;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.admin.dao.UsersDao;
import com.admin.entities.Category;
import com.admin.entities.Users;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;



@Controller
public class UsersController {
	@Autowired
	UsersDao usersdao;
	@RequestMapping(value = {"userdetailt"}, method=RequestMethod.GET)
	public String requestMethodName(Model model) {
		List<Users> listUser = usersdao.listUsers();
		model.addAttribute("user", listUser);
		model.addAttribute("page","home");
	    return "admin";
	}
	
	@RequestMapping(value= {"insert"}, method=RequestMethod.GET)
	public String insert(Model model) {
	    Users users = new Users();
	    model.addAttribute("users",users);
	    model.addAttribute("page", "insertUsers");
		return "admin";
	}
//	them du lieu
	@RequestMapping(value= {"save"}, method=RequestMethod.POST)
	public String save(@Valid @ModelAttribute("users") Users user, BindingResult result, Model model ,@RequestParam("images") MultipartFile file ,HttpServletRequest req) {
		if(result.hasErrors()) {

			model.addAttribute("users",user);
			model.addAttribute("page", "insertUsers");
			return "admin";

			}else {
				try {
					if(file!=null && !file.isEmpty()) {

						String uploadRootPath = req.getServletContext().getRealPath("resources/images");

						File destination = new File(uploadRootPath+"/"+file.getOriginalFilename());

						try {

						file.transferTo(destination);

						} catch (IllegalStateException | IOException e) {

						e.printStackTrace();

						}
//						 String imagePath = "resources/images/" + file.getOriginalFilename();
						user.setAvatar("resources/images/"+file.getOriginalFilename());
//						 user.setImages(imagePath);

						}

					usersdao.insert(user);
				} catch (Exception e) {
					model.addAttribute("error",e.getMessage());
					model.addAttribute("student",user);
					model.addAttribute("page", "insertUsers");
					return "admin";
				}
				return "redirect:/";
			}
		
	}
	
//	login
	@RequestMapping(value = {"/", "login"})
	public String index(Model model) {
		model.addAttribute("page", "login");
		return "admin";
	}
//	login users
	@RequestMapping(value = {"loginUsers"}, method=RequestMethod.POST)
	public String loginUsers(Model model, HttpSession session,@RequestParam("email") String email, @RequestParam("password") String password) {
		List<Users> list = usersdao.login(email, password);
		if(list != null) {
			 Users loggedInUser =  list.get(0); 
		     session.setAttribute("loggedInUser", loggedInUser);
		     session.setAttribute("user", loggedInUser);
			model.addAttribute("page", "home");
			return "admin";
		}else {
			model.addAttribute("page", "login");
			return "admin";
		}
	}
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
	    session.invalidate();
	    
	    return "redirect:/login";
	}
}
