package com.myshopping.MYShopping.service;

import com.myshopping.MYShopping.dto.BillDTO;
import com.myshopping.MYShopping.dto.OrderDetailsDTO;
import com.myshopping.MYShopping.dto.OrderProductDTO;
import com.myshopping.MYShopping.models.AppUser;
import com.myshopping.MYShopping.models.OrderTable;
import com.myshopping.MYShopping.models.Product;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.myshopping.MYShopping.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class BuyerService {

    private final UserService userService;
    private final ProductService productService;
    private  final OrderRepository orderRepository;
  // private final MailService mailService;
    public OrderTable placeOrder(List<OrderDetailsDTO> orderDetailsDTOList, UUID userId){

        AppUser user=userService.getUserById(userId);
        OrderTable orderTable=new OrderTable();
        BillDTO bill=new BillDTO();
        int totalPrice=0;
        int totalQuantity=0;

        List<OrderProductDTO>orderProducts=new ArrayList<>();
        List<Product>products=new ArrayList<>();

        for(OrderDetailsDTO order: orderDetailsDTOList){
            OrderProductDTO orderProduct=new OrderProductDTO();
            UUID productId=order.getId();
            orderProduct.setProductID(productId);
            totalQuantity+=order.getQuantity();
            Product product=productService.getProductById(productId);
            orderProduct.setProductName(product.getName());
            orderProduct.setQuantity(order.getQuantity());
            totalPrice=(order.getQuantity()*product.getPrice());
            products.add(product);
            orderTable.setPaymentMode(order.getPaymentMode());
            orderProducts.add(orderProduct);
            int updatedQuantity=product.getQuantity()-order.getQuantity();
            productService.updateProductQuantity(productId,updatedQuantity);
        }


        bill.setBuyerID(user.getId());
        bill.setBuyerName(user.getName());
        bill.setTotalPrice(totalPrice);
        bill.setTotalQuantity(totalQuantity);
        bill.setEmailID(user.getEmail());
        bill.setOrderProducts(orderProducts);
        orderTable.setProducts(products);
        orderTable.setUser(user);
        orderTable.setStatus("Not Delivered");
        orderTable.setTotalPrice(totalPrice);
        orderTable.setTotalQuantity(totalQuantity);



        orderRepository.save(orderTable);
       // mailService.sendMail("Hey, Order got placed", user.getEmail(), "Congratulation!!! order got placed");

       // bill.setBillID(orderTable.getOrderId());
        return orderTable;

    }
}
