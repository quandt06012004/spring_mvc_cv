package com.admin.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.admin.dao.imp.CustomerImp;
import com.admin.entities.Category;
import com.admin.entities.Customers;

@Controller
public class CustomerControllers {
	@Autowired
	private CustomerImp cusDao;
	
	@RequestMapping(value = {"showcustomer"})
	public String showCategories(Model model) {
		List<Customers> listCus = cusDao.listCustomers();
		model.addAttribute("cus", listCus);
		model.addAttribute("page","inforCustomer");
	    return "admin";
	}
	@RequestMapping(value = {"insetCustomer"})
	public String insertCategories(Model model) {
		model.addAttribute("cus", new Customers());
		model.addAttribute("page", "insertCustomer");
		return "admin";
	}
	@RequestMapping(value= "saveCustomer",method = RequestMethod.POST)

	public String addEmployee(@ModelAttribute("cus")Customers cus,Model model) {

	try {

		cusDao.insertCustomer(cus);

		}catch(Exception ex) {

		model.addAttribute("error",ex.getMessage());

		model.addAttribute("cus",cus);
		model.addAttribute("page", "insetCustomer");
		return "admin";

		}

		return "redirect:/showcustomer";

	}
	@RequestMapping(value = {"editCustomer"}, method=RequestMethod.GET)
	public String UpdateCategories(@RequestParam("id") int id,Model model) {
		Customers cus = cusDao.getCustomerById(id);
		model.addAttribute("cus",cus);
		model.addAttribute("page", "editCustomer");
		return "admin";
	}
	@RequestMapping(value = {"UpdateCustomer"}, method=RequestMethod.POST)
	public String requestMethodName(@ModelAttribute("cus") Customers cus, Model model) {
		try {

			cusDao.updateCustomer(cus);

			}catch(Exception ex) {

			model.addAttribute("error",ex.getMessage());

			model.addAttribute("cus",cus);

			model.addAttribute("page", "editCustomer");
			return "admin";

			}

			return "redirect:/showcustomer";
	}
	
	@RequestMapping(value = {"deleteCustomer"}, method=RequestMethod.GET)
	public String requestMethodName(@RequestParam("id") int id) {
		cusDao.deleteCustomer(id);
		return "redirect:/showcustomer";
	}
}
