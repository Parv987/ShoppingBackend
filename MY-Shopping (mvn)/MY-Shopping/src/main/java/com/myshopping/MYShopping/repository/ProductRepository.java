package com.myshopping.MYShopping.repository;

import jakarta.transaction.Transactional;
import com.myshopping.MYShopping.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

    @Query(value="select * from product where category=:category and name =:name",nativeQuery = true)

    public List<Product> getProductsByCategoryAndName(String category,String name);

    @Query(value="select * from product where category=:category",nativeQuery = true)
    public List<Product> getProductsByCategory(String category);


    @Query(value="select * from product where name=:name",nativeQuery = true)
    public List<Product> getProductsByName(String name);


    @Transactional
    @Modifying
    @Query(value="update product set quantity=:quantity where id=:productId",nativeQuery = true)
    public void updateProductQuantity(UUID productId,int quantity);


}
