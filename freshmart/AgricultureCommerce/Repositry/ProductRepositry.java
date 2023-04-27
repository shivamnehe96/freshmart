package com.rutikProject.AgricultureCommerce.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rutikProject.AgricultureCommerce.Entiy.Product;

public interface ProductRepositry extends JpaRepository<Product, Long> {

}
