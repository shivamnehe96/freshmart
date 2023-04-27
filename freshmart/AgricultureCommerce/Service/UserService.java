package com.rutikProject.AgricultureCommerce.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rutikProject.AgricultureCommerce.Entiy.User;
import com.rutikProject.AgricultureCommerce.Repositry.UserRepositry;


@Service
public class UserService {
	
	@Autowired
	private UserRepositry repo;
	
	public User addUser(User User)
	{
		return repo.save(User);
	}
	
	public List<User> getall()
	{
		return repo.findAll();
	}
	
	public User getbyid(Long id)
	{
		return repo.findById(id).orElse(null);
	}
	
	public void delete(Long id)
	{
		repo.deleteById(id);
	}
	
	public User findByEmail(String email) {
		return  repo.findByEmail(email);
	}

}
