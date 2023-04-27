package com.rutikProject.AgricultureCommerce.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rutikProject.AgricultureCommerce.Entiy.Cart;
import com.rutikProject.AgricultureCommerce.Entiy.ImageGallery;
import com.rutikProject.AgricultureCommerce.Entiy.User;
import com.rutikProject.AgricultureCommerce.Service.CartService;
import com.rutikProject.AgricultureCommerce.Service.ImageGalleryService;
import com.rutikProject.AgricultureCommerce.Service.UserService;

@Controller
public class WebController {

	
	@Autowired
	private UserService service;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private ImageGalleryService imageGalleryService;
	
	
	  @RequestMapping(value = "/", method = RequestMethod.GET) 
	  public String viewHomePage(Model model) {

			//return "index";
		  model.addAttribute("loginMsg", "");
			
		  return "user-login";
		}
	 
	 

	/*
	 * @RequestMapping(value = { "/{page}", "/" }, method = RequestMethod.GET)
	 * public String typedTestBean(@PathVariable Map<String, String> pathVariables)
	 * {
	 * 
	 * String htmlPage = pathVariables.get("page"); if
	 * (pathVariables.containsKey(htmlPage)) { return htmlPage.substring(0,
	 * htmlPage.lastIndexOf('.')); } else { return "index"; } }
	 */
	
	@RequestMapping(value = { "/{page}" }, method = RequestMethod.GET)
	public String typedTestBean(@PathVariable Map<String, String> pathVariables , Model model) {

		String htmlPage = pathVariables.get("page");
		
		if(htmlPage.equals("user-register.html"))
		{
			 User user = new User();
			 model.addAttribute("user", user);			     
			 return "user-register";
			
		}
		else if("product-cart.html".equals(htmlPage)) {
			
			return "redirect:/viewCart";
		}
		else
		{
			
				List<ImageGallery> images = imageGalleryService.getAllActiveImages();
				model.addAttribute("images", images);
				
				List<Cart> cart = cartService.getAllActiveImages();
				if(cart != null && !cart.isEmpty()) {
					double sum = cart.stream().mapToDouble(Cart::getPrice).sum();
					model.addAttribute("cartTotal", sum);
					
				}
				model.addAttribute("cart", cart);
				
			    return htmlPage;
			
		}
		
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String addRecord(@ModelAttribute("User") User user)
	{
		service.addUser(user);		
		return "redirect:/";
	}

}
