package com.app.ecom.repository;

import com.app.ecom.model.AppUser;
import com.app.ecom.model.CartItem;
import com.app.ecom.model.Product;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    CartItem findByAppUserAndProduct(AppUser appUser, Product product);
}
