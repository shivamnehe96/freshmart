package com.rutikProject.AgricultureCommerce.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rutikProject.AgricultureCommerce.Entiy.User;


public interface UserRepositry extends JpaRepository<User, Long> {

	User findByEmail(String email);

}
