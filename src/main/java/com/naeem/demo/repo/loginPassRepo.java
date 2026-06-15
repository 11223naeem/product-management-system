package com.naeem.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naeem.demo.Product.Product;
import com.naeem.demo.pssword.LoginPass;

public interface loginPassRepo extends JpaRepository<LoginPass, String> {

	LoginPass findByName(String name);

	LoginPass findBypassword(String pass);

}
