package com.myshopping.MYShopping.dto;

import lombok.*;

import java.util.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BillDTO {
    UUID billID;
    String buyerName;
    UUID buyerID;
    String emailID;
    int totalQuantity;
    int totalPrice;
    List<OrderProductDTO>orderProducts;
}
