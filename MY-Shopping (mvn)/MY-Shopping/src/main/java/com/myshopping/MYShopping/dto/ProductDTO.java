package com.myshopping.MYShopping.dto;

import lombok.*;

import java.util.*;

@NoArgsConstructor
//@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProductDTO {
     static  UUID id;
    static String productName;
    static String productCategory;
    static String rating;
    static String description;
    static String sellerName;
    static int price;

    public static UUID getId() {
        return id;
    }

    public static void setId(UUID id) {
        ProductDTO.id = id;
    }

    public static String getProductName() {
        return productName;
    }

    public static void setProductName(String productName) {
        ProductDTO.productName = productName;
    }

    public static String getProductCategory() {
        return productCategory;
    }

    public static void setProductCategory(String productCategory) {
        ProductDTO.productCategory = productCategory;
    }

    public static String getRating() {
        return rating;
    }

    public static void setRating(String rating) {
        ProductDTO.rating = rating;
    }

    public static String getDescription() {
        return description;
    }

    public static void setDescription(String description) {
        ProductDTO.description = description;
    }

    public static String getSellerName() {
        return sellerName;
    }

    public static void setSellerName(String sellerName) {
        ProductDTO.sellerName = sellerName;
    }

    public static int getPrice() {
        return price;
    }

    public static void setPrice(int price) {
        ProductDTO.price = price;
    }
}
