package com.example.demo.repository;

import com.example.demo.entities.Product;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p from Product p WHERE p.price > :minPrice")
    List<Product> findExpensiveProducts(@Param("minPrice") double minPrice);

    @Query(value="Select * FROM product WHERE MATCH(title,description) AGAINST (:keyword)", nativeQuery = true)
    List<Product> searchFullText(@Param("keyword") String keyword);

}
