package com.cloudnative.itemcart.repo;

import com.cloudnative.itemcart.entity.ItemCart;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class ItemCartRepositoryUnitTest {

    @Autowired
    private ItemCartRepository itemCartRepository;

    @Test
    void save_should_insert_new_item_cart(){
        //Given
        ItemCart cart = new ItemCart(null,"item 01", 12D, 0);
        //When
        ItemCart saveCart = itemCartRepository.save(cart);
        //Then
        Assertions.assertNotNull(saveCart);
        Assertions.assertEquals(saveCart.getName(),cart.getName());
        Assertions.assertEquals(saveCart.getPrice(),cart.getPrice());
        Assertions.assertEquals(saveCart.getVersion(),0);
    }
}
