package com.rutikProject.AgricultureCommerce.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rutikProject.AgricultureCommerce.Entiy.Cart;


@Repository
public interface CartRepository extends JpaRepository<Cart, Long>{

}

