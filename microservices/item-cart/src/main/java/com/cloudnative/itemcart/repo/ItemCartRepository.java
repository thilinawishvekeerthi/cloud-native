package com.cloudnative.itemcart.repo;

import com.cloudnative.itemcart.entity.ItemCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemCartRepository extends JpaRepository<ItemCart, Long> {
}
