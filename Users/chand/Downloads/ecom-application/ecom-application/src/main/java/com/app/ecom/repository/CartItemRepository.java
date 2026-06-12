package com.app.ecom.repository;

import com.app.ecom.model.AppUser;
import com.app.ecom.model.CartItem;
import com.app.ecom.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    CartItem findByAppUserAndProduct(AppUser appUser, Product product);

    void deleteByAppUserAndProduct(AppUser user, Product product);

    List<CartItem> findByAppUser(AppUser appUser);

    void deleteByAppUser(AppUser user);
}
