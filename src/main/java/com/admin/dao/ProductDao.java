package com.admin.dao;

import java.util.List;

import com.admin.entities.Product;

public interface ProductDao {
	public List<Product> listProduct(Integer offset, Integer maxResult);
	public boolean insertProduct(Product p);
	public Product getProductById(Integer proId);
	public boolean deleteProduct(Integer proId);
	public boolean updateProduct(Product p);
	public List<Product> getProductByName(String name, Integer offset, Integer maxResult);
	public long getTotalProductPagination();
	public long getTotalProductPaginationByName(String name);
}
