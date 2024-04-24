package com.myshopping.MYShopping.repository;

import com.myshopping.MYShopping.models.OrderTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<OrderTable, UUID> {

}
