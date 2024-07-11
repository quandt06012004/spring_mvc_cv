package com.admin.controllers;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.admin.dao.imp.Categoriesimp;
import com.admin.dao.imp.ProductImp;
import com.admin.entities.Category;
import com.admin.entities.Product;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class ProductController {
@Autowired
private ProductImp productDAO;

@Autowired
private Categoriesimp categoriesImp;
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sf, true));
	}
	
	@RequestMapping(value = {"listProducts"}, method=RequestMethod.GET)
	public String listProducts(Integer page, Model model) {
		Integer itemPerPage =4;
		Integer offset;
		if(page == null) {
			offset = 0;
		}else {
			offset = (page - 1)*itemPerPage;
		}
		List<Product> products = productDAO.listProduct(offset, itemPerPage);
		model.addAttribute("pro", products);
		
		long totals = productDAO.getTotalProductPagination();
		Integer totalPage = (int) (totals/itemPerPage + ( totals%itemPerPage == 0?0:1));
		List<Integer> listPage = new ArrayList<Integer>();
		for (int i = 1; i <= totalPage; i++) {
			listPage.add(i);
		}
		model.addAttribute("listPage",listPage);
		model.addAttribute("page", "inforProducts");
		return "admin";
	}

	@RequestMapping("/initInsertProduct")
	public String initInsertProduct(Model model) {
		List<Category> listCat = categoriesImp.listCategory();
		model.addAttribute("c",listCat);
		
		Product p = new Product();
 		model.addAttribute("pro", p);
		model.addAttribute("page", "insertProduct");
		return "admin";
	}
	
	@RequestMapping(value = {"insertProduct"}, method = RequestMethod.POST)
	public String insertProduct(@Valid @ModelAttribute("pro")Product p, BindingResult result, @RequestParam("img") MultipartFile file, Model model, HttpServletRequest req) {
		
		if(result.hasErrors()) {
			List<Category> listCat = categoriesImp.listCategory();
			model.addAttribute("c",listCat);
			model.addAttribute("pro",p);
			model.addAttribute("page", "insertProduct");
			return "admin";
		
			}else
			{
				if(file!=null) {

					String uploadRootPath = req.getServletContext().getRealPath("resources/images");

					File destination = new File(uploadRootPath+"/"+file.getOriginalFilename());

					try {

					file.transferTo(destination);

					} catch (IllegalStateException | IOException e) {

					e.printStackTrace();

					}

					p.setImage("resources/images/"+file.getOriginalFilename());

					}
						boolean bl = productDAO.insertProduct(p);
						if(bl) {
							return "redirect:/listProducts";
						}else {
							model.addAttribute("p", p);
							List<Category> listCat = categoriesImp.listCategory();
							model.addAttribute("c",listCat);
							model.addAttribute("error", "insert failed!");
							model.addAttribute("page", "insertProduct");
							return "admin";
						}
					
			}
	}
		@RequestMapping(value = {"deleteProduct"}, method=RequestMethod.GET)
		public String deleteProduct(@RequestParam("id") int id, Model model) {
		    boolean bl = productDAO.deleteProduct(id);
			if(bl) {
				return "redirect:/listProducts";
			}
			return "";
		}
		@RequestMapping(value = {"detailtProduct"}, method=RequestMethod.GET)
		public String detailtProduct(@RequestParam("id") int id, Model model) {
		    Product p = productDAO.getProductById(id);
			model.addAttribute("pro", p);
			model.addAttribute("page", "detailtProduct");
			return "admin";
		}
		@RequestMapping(value = {"updateProduct"}, method=RequestMethod.GET)
		public String updateProduct(@RequestParam("id") int id, Model model) {
				List<Category> listCat = categoriesImp.listCategory();
				model.addAttribute("c",listCat);
			 	Product p = productDAO.getProductById(id);
				model.addAttribute("pro", p);
				model.addAttribute("page", "editProduct");
				return "admin";
		}
		@RequestMapping(value = {"editProduct"}, method=RequestMethod.POST)
		public String requestMethodName(@ModelAttribute("pro") Product p, Model model,@RequestParam("img") MultipartFile file, HttpServletRequest req) {
			if(file!=null && !file.isEmpty()) {

				String uploadRootPath = req.getServletContext().getRealPath("resources/images");

				File destination = new File(uploadRootPath+"/"+file.getOriginalFilename());

				try {

				file.transferTo(destination);

				} catch (IllegalStateException | IOException e) {

				e.printStackTrace();

				}

				p.setImage("resources/images/"+file.getOriginalFilename());

				}else {
					  Product existingProduct = productDAO.getProductById(p.getProId());
				      p.setImage(existingProduct.getImage());
				}
					
					boolean bl = productDAO.updateProduct(p);
					if(bl) {
						return "redirect:/listProducts";
					}else {
						List<Category> listCat = categoriesImp.listCategory();
						model.addAttribute("c",listCat);
						model.addAttribute("pro", p);
						model.addAttribute("error", "insert failed!");
						model.addAttribute("page", "editProduct");
						return "admin";
					}
				
		}
		@RequestMapping("/searchProductByName")
		public String searchProductByName(@RequestParam("proName")String proName,Integer page, Model model) {
			Integer itemPerPage = 4;
			Integer offset;
			if(page == null) {
				offset = 0;
			}else {
				offset = (page - 1)*itemPerPage;
			}
			List<Product> products = productDAO.getProductByName(proName,offset, itemPerPage);
			model.addAttribute("pro", products);
			
			long totals = productDAO.getTotalProductPaginationByName(proName);
			Integer totalPage = (int) (totals/itemPerPage + ( totals%itemPerPage == 0?0:1));
			
			List<Integer> listPage = new ArrayList<Integer>();
			for (int i = 1; i <= totalPage; i++) {
				listPage.add(i);
			}
			model.addAttribute("listPagesearch",listPage);
			model.addAttribute("page", "inforProducts");
			return "admin";
		}

		
}
		
		

