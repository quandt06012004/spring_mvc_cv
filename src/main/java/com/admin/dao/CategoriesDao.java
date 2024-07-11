package com.admin.dao;

import java.util.List;

import com.admin.entities.Category;

public interface CategoriesDao {
	public List<Category> listCategory();
	public boolean insertCategory(Category c);
	public Category getCategoryById(int catId);
	public boolean deleteCategory(int catId);
	public boolean updateCategory(Category c);
	public List<Category> getCategoryByName(String name);
}
