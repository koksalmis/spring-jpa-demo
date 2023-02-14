package com.koksalmis.springjpademo.repository;

import com.koksalmis.springjpademo.models.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

}