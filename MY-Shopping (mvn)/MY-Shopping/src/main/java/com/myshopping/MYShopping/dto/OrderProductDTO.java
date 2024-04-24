package com.myshopping.MYShopping.dto;

import lombok.*;

import java.util.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class OrderProductDTO {
    UUID productID;
    String productName;
    int quantity;
}
