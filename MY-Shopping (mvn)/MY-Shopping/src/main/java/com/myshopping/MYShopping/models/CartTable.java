package com.myshopping.MYShopping.models;

import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class CartTable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    int quantity;
    @OneToOne
    AppUser user;
    int totalPrice;
    @OneToMany
    List<Product> products;

    public CartTable(UUID id, int quantity, AppUser user, int totalPrice, List<Product> products) {
        this.id = id;
        this.quantity = quantity;
        this.user = user;
        this.totalPrice = totalPrice;
        this.products = products;
    }

    public CartTable() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
