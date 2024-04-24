package com.myshopping.MYShopping.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

    @Entity// This annotation tell hibernate that you need to crate
    //table for this class
    public class AppUser {

        @Id//make UUID primary key so that hibernate can recognize it
        UUID id;

        @Column(nullable = false)
        String name;

        @Column(unique = true,nullable = false)
        String email;

        @Column(nullable = false)

        String password;

        @Column(unique = true)
        String userType;

        @Column(unique = true,length = 10)
        Long phoneNumber;
        public AppUser(){

        }

        public AppUser(UUID id, String name, String email, String password,String userType,Long phoneNumber) {
            this.id = id;
            this.name = name;
            this.email = email;
            this.password = password;
            this.userType = userType;
            this.phoneNumber = phoneNumber;

        }

        public UUID getId() {
            return id;
        }

        public void setId(UUID id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getUserType() {
            return userType;
        }

        public void setUserType(String userType) {
            this.userType = userType;
        }

        public Long getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(Long phoneNumber) {
            this.phoneNumber = phoneNumber;
        }
    }


