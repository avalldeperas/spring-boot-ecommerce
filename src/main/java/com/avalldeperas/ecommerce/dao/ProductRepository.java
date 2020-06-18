package com.avalldeperas.ecommerce.dao;


import com.avalldeperas.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Product class is the Entity; Long is the primary key
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

}
