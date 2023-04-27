package com.rutikProject.AgricultureCommerce.Controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.rutikProject.AgricultureCommerce.Entiy.Cart;
import com.rutikProject.AgricultureCommerce.Entiy.ImageGallery;
import com.rutikProject.AgricultureCommerce.Service.CartService;
import com.rutikProject.AgricultureCommerce.Service.ImageGalleryService;

@Controller
public class CartController {

	@Value("${uploadDir}")
	private String uploadFolder;

	@Autowired
	private ImageGalleryService imageGalleryService;

	@Autowired
	private CartService cartService;

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/savecart/{id}/{qty}")
	public RedirectView addCoustmer(@PathVariable("id") Long id,@PathVariable("qty") int qty) {
		RedirectView redirectView = new RedirectView("/product-grid-left-sidebar", true);

		Optional<ImageGallery> cart;
		cart = imageGalleryService.getImageById((id));
		ImageGallery c = cart.get();
		Cart cartObj = new Cart();
		// cartObj.setId(c.getId());
		cartObj.setName(c.getName());
		cartObj.setPrice(c.getPrice()*(qty));
		cartObj.setDescription(c.getDescription());
		cartObj.setImage(c.getImage());
		cartObj.setCreateDate(c.getCreateDate());
		cartObj.setQuantity(qty);

		cartService.saveCart(cartObj);
		return redirectView;

	}

	@GetMapping("/product-grid-left-sidebar")
	public String getProductDetails(final Model model) {
		List<ImageGallery> images = imageGalleryService.getAllActiveImages();
		model.addAttribute("images", images);
		return "product-grid-left-sidebar";
	}

	@GetMapping("/cart/display/{id}")
	@ResponseBody
	void showImage(@PathVariable("id") Long id, HttpServletResponse response, Optional<Cart> cart)
			throws ServletException, IOException {
		log.info("Id :: " + id);
		cart = cartService.getImageById(id);
		response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
		response.getOutputStream().write(cart.get().getImage());
		response.getOutputStream().close();
	}

	@RequestMapping("/deletecart/{id}")
	public RedirectView deleteProduct(@PathVariable(name = "id") Long id, Model map, RedirectAttributes redir) {
		cartService.delete(id);
		List<Cart> cart = cartService.getAllActiveImages();
		if (cart != null && !cart.isEmpty()) {
			double sum = cart.stream().mapToDouble(Cart::getPrice).sum();
			redir.addFlashAttribute("cartTotal", sum);

		}
		// map.addAttribute("cart", cart);
		RedirectView redirectView = new RedirectView("/", true);
		redirectView = new RedirectView("/index", true);
		// redir.addAttribute("image",imageGalleryOptional.get());
		redir.addFlashAttribute("cart", cart);

		return redirectView;
		// return "index";
	}
	
	@GetMapping("/viewCart")
	public String viewCart(final Model model) {
		//List<ImageGallery> images = imageGalleryService.getAllActiveImages();
		//model.addAttribute("images", images);
		List<Cart> cart = cartService.getAllActiveImages();
		double sum = 0.0;
		if (cart != null && !cart.isEmpty()) {
			 sum = cart.stream().mapToDouble(Cart::getPrice).sum();
			

		}
		model.addAttribute("cartTotal", sum);
		model.addAttribute("cart", cart);
		return "product-cart";
	}
}

