package com.rutikProject.AgricultureCommerce.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rutikProject.AgricultureCommerce.Entiy.Product;
import com.rutikProject.AgricultureCommerce.Repositry.ProductRepositry;

@Service
public class ProductService {

	@Autowired
	ProductRepositry repositry;
	
	public Product addProduct(Product Product)
	{
		return repositry.save(Product);
	}
	
	public List<Product> getall()
	{
		return repositry.findAll();
	}
	
	public Product getbyid(Long id)
	{
		return repositry.findById(id).orElse(null);
	}
	
	public void delete(Long id)
	{
		repositry.deleteById(id);
	}
	

}
