package com.avalldeperas.ecommerce.dao;


import com.avalldeperas.ecommerce.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Product class is the Entity; Long is the primary key
 */
@CrossOrigin("http://localhost:4200")
public interface ProductRepository extends JpaRepository<Product, Long> {

    // Spring will automatically execute a Query for us using 'findBy*'.
    // Page is a sublist of an Object List
    Page<Product> findByCategoryId(@RequestParam("id") Long id, Pageable pageable);

}
