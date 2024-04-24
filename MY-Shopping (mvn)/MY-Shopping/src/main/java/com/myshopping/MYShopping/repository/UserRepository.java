package com.myshopping.MYShopping.repository;

import com.myshopping.MYShopping.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

// we are making UserRepository interface because Jpa needs to do everything
@Repository
public interface UserRepository extends JpaRepository<AppUser, UUID> {
public List<AppUser>findByEmail(String Email);
}
