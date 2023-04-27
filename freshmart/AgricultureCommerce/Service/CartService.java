package com.rutikProject.AgricultureCommerce.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rutikProject.AgricultureCommerce.Entiy.Cart;
import com.rutikProject.AgricultureCommerce.Entiy.ImageGallery;
import com.rutikProject.AgricultureCommerce.Repositry.CartRepository;
import com.rutikProject.AgricultureCommerce.Repositry.ImageGalleryRepository;



@Service
public class CartService {

	@Autowired
	private CartRepository cartRepository;
	
	public void saveCart(Cart cart) {
		cartRepository.save(cart);	
	}

	public List<Cart> getAllActiveImages() {
		return cartRepository.findAll();
	}

	public Optional<Cart> getImageById(Long id) {
		return cartRepository.findById(id);
	}
	
	public void delete(Long id)
	{
		cartRepository.deleteById(id);
	}
}

