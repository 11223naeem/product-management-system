package com.naeem.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.naeem.demo.Product.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{

	List<Product> findByName(String str);

	List<Product> findByWarrenty(int warrenty);


	List<Product> findByTypeContainingIgnoreCase(String type);

}
