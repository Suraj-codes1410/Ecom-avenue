package com.app.ecom.service;

import com.app.ecom.dto.OrderResponse;
import com.app.ecom.model.AppUser;
import com.app.ecom.model.CartItem;
import com.app.ecom.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final CartService cartService;
    private final UserRepository userRepository;

    public Optional<OrderResponse> createOrder(String userId){
        //Validate For cart Item
        List<CartItem> cartItems = cartService.getCart(userId);
        if(cartItems.isEmpty()){
         return Optional.empty();
        }
        //Validate for User
        Optional<AppUser> userOptional =  userRepository.findById(Long.valueOf(userId));

        if(userOptional.isEmpty()){
            return Optional.empty();
        }
        AppUser User = userOptional.get();
        //Calculate total price
        BigDecimal totalprice = cartItems.stream()
                .map(CartItem::getPrice)
                .reduce(BigDecimal.ZERO,BigDecimal::add);
        //Create order
        //Clear the cart
    }
}
