package com.admin.controllers;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.admin.dao.imp.CustomerImp;
import com.admin.dao.imp.InvoiceImp;
import com.admin.entities.Category;
import com.admin.entities.Customers;
import com.admin.entities.Invoices;
import com.admin.entities.Product;

@Controller
public class InvoiceController {
	@Autowired
	private InvoiceImp inDao;
	@Autowired
	private CustomerImp cusDao;
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sf, true));
	}
	
	@RequestMapping(value = {"listInvoices"}, method=RequestMethod.GET)
	public String listProducts( Model model) {
		List<Invoices> in = inDao.listInvoices();
		model.addAttribute("in", in);
		model.addAttribute("page", "inforInvoices");
		return "admin";
		
	}
	
	@RequestMapping("/initInsertInvoices")
	public String initInsertProduct(Model model) {
		List<Customers> cus = cusDao.listCustomers();
		model.addAttribute("cus",cus);
		
		Invoices in = new Invoices();
 		model.addAttribute("in", in);
		model.addAttribute("page", "insertInvoices");
		return "admin";
	}
	
	@RequestMapping(value = {"insertInvoices"}, method = RequestMethod.POST)
	public String insertProduct(@Valid @ModelAttribute("in")Invoices in, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			List<Customers> cus = cusDao.listCustomers();
			model.addAttribute("cus",cus);
			model.addAttribute("in",in);
			model.addAttribute("page", "insertInvoices");
			return "admin";
		
			}
		    else {
				
						boolean bl = inDao.insertInvoice(in);
						if(bl) {
							return "redirect:/listInvoices";
						}else {
							List<Customers> cus = cusDao.listCustomers();
							model.addAttribute("cus",cus);
							model.addAttribute("error", "insert failed!");
							model.addAttribute("page", "insertInvoices");
							return "admin";
						}
					
			}
	}
	
	@RequestMapping(value = {"editProduct"}, method=RequestMethod.GET)
	public String updateProduct(@RequestParam("id") int id, Model model) {
			
			List<Customers> cus = cusDao.listCustomers();
			model.addAttribute("cus",cus);
		 	Invoices in = inDao.getInvoiceById(id);
			model.addAttribute("in", in);
			model.addAttribute("page", "editInvoices");
			return "admin";
	}
	
	@RequestMapping(value = {"updateInvoices"}, method=RequestMethod.POST)
	public String requestMethodName(@ModelAttribute("in") Invoices in, Model model) {
		
				boolean bl = inDao.updateInvoice(in);
				if(bl) {
					return "redirect:/listInvoices";
				}else {
					List<Customers> cus = cusDao.listCustomers();
					model.addAttribute("cus",cus);
					model.addAttribute("in", in);
					model.addAttribute("error", "insert failed!");
					model.addAttribute("page", "editProduct");
					return "admin";
				}
			
	}
	
	@RequestMapping(value = {"deleteInvoices"}, method=RequestMethod.GET)
	public String deleteProduct(@RequestParam("id") int id, Model model) {
	    boolean bl = inDao.deleteInvoices(id);
		if(bl) {
			return "redirect:/listInvoices";
		}
		return "";
	}
	
	
	
	 @RequestMapping("/searchInvoidBydate")
	    public String searchProductByName(@RequestParam("id") Integer id, Model model) {
	        List<Invoices> in = inDao.getInvoiceSearchId(id);
	        model.addAttribute("in", in);
	        model.addAttribute("page", "inforInvoices");
	        return "admin";
	    }
	
}
