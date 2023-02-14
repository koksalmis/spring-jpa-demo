package com.koksalmis.springjpademo.repository;

import com.koksalmis.springjpademo.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {

}