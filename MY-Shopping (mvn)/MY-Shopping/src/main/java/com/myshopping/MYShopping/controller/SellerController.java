package com.myshopping.MYShopping.controller;

import com.myshopping.MYShopping.exception.ResourceNotFound;
import com.myshopping.MYShopping.exception.UnAuthorized;
import com.myshopping.MYShopping.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.myshopping.MYShopping.service.ProductService;

import java.util.UUID;

@RestController
@RequestMapping("/seller")
public class SellerController {

    @Autowired
    ProductService productService;

    @PostMapping("/product/add")
    public String addProduct(@RequestBody Product product, @RequestParam UUID sellerId){

        try{
            productService.registerProduct(product,sellerId);
        }catch (ResourceNotFound resourceNotFound){
                return resourceNotFound.getMessage();
        }catch(UnAuthorized unAuthorized){
            return unAuthorized.getMessage();
        }
        return "Product got saved successfully";
    }
}
