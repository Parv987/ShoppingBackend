package com.myshopping.MYShopping.controller;

import com.myshopping.MYShopping.dto.ProductDTO;
import com.myshopping.MYShopping.models.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.myshopping.MYShopping.service.ProductService;
import com.myshopping.MYShopping.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CommonController {
    @Autowired
    UserService userService;
    @PostMapping("user/register")
    public String registerUser(@RequestBody AppUser appUser){
   userService.registerUser(appUser);
    return "successfully saved";
    }

    @Autowired
    ProductService productService;
    @GetMapping("/product/search")
    public List<ProductDTO> searchProductByCategory(@RequestParam(required = false) String category, @RequestParam(required = false) String productName){
         if(category!=null && productName!=null){
             return productService.searchByCategoryAndProductName(category,productName);
         }else if(category!=null){
             return productService.searchByCategory(category);
         }else if(productName!=null){
             return productService.searchByProductName(productName);
         }else{
             return productService.getAllProducts();
         }

    }
}
