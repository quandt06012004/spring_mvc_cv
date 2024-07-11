package com.admin.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.admin.dao.CategoriesDao;
import com.admin.dao.imp.Categoriesimp;
import com.admin.entities.Category;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class CategoriesController {
@Autowired
private Categoriesimp catDao;
@RequestMapping(value = {"showCategory"})
	public String showCategories(Model model) {
		List<Category> listcat = catDao.listCategory();
		model.addAttribute("cat", listcat);
		model.addAttribute("page","inforCategory");
	    return "admin";
	}
	@RequestMapping(value = {"insetCategories"})
	public String insertCategories(Model model) {
		model.addAttribute("cat", new Category());
		model.addAttribute("page", "insertCategories");
		return "admin";
	}
	@RequestMapping(value= "saveCategory",method = RequestMethod.POST)

	public String addEmployee(@ModelAttribute("cat")Category cat,Model model) {

	try {

		catDao.insertCategory(cat);

		}catch(Exception ex) {

		model.addAttribute("error",ex.getMessage());

		model.addAttribute("cat",cat);
		model.addAttribute("page", "insertCategories");
		return "admin";

		}

		return "redirect:/showCategory";

	}
	@RequestMapping(value = {"editCategory"}, method=RequestMethod.GET)
	public String UpdateCategories(@RequestParam("id") int id,Model model) {
		Category cat = catDao.getCategoryById(id);
		model.addAttribute("cat",cat);
		model.addAttribute("page", "editCategories");
		return "admin";
	}
	@RequestMapping(value = {"UpdateCategory"}, method=RequestMethod.POST)
	public String requestMethodName(@ModelAttribute("cat") Category cat, Model model) {
		try {

			catDao.updateCategory(cat);

			}catch(Exception ex) {

			model.addAttribute("error",ex.getMessage());

			model.addAttribute("cat",cat);

			model.addAttribute("page", "editCategories");
			return "admin";

			}

			return "redirect:/showCategory";
	}
	
	@RequestMapping(value = {"deleteCategory"}, method=RequestMethod.GET)
	public String requestMethodName(@RequestParam("id") int id) {
		catDao.deleteCategory(id);
		return "redirect:/showCategory";
	}
	
}
