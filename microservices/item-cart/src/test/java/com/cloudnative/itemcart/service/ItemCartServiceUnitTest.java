package com.cloudnative.itemcart.service;

import com.cloudnative.itemcart.dto.ItemCartDto;
import com.cloudnative.itemcart.entity.ItemCart;
import com.cloudnative.itemcart.repo.ItemCartRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ItemCartServiceUnitTest {

    @Mock
    private ItemCartRepository itemCartRepository;

    private ItemCartService itemCartService;

    ItemCart itemCart ;
    ItemCart itemCartTwo;
    ItemCartDto itemCartDto;
    ItemCartDto itemCartDtoTwo;

    @BeforeEach
    void setUp(){
        itemCartService = new ItemCartServiceImpl(itemCartRepository);
        itemCart = new ItemCart(1L,"item 01",10D, 0);
        itemCartTwo = new ItemCart(2L,"item 02",20D, 1);
        itemCartDto = new ItemCartDto(1L,"item 01",10D, 0);
        itemCartDtoTwo = new ItemCartDto(2L,"item 02",20D, 1);
    }

    @Test
    void find_item_cart_by_id(){
        //Given
        //When
        when(itemCartRepository.findById(1L)).thenReturn(Optional.of(itemCart));
        ItemCartDto findItem = itemCartService.get(1L);
        //Then
        assertEquals(itemCart.getId(), findItem.getId());
        verify(itemCartRepository).findById(1L);
    }

    @Test
    void find_All_item_cart_by(){
        //Given
        //When
        when(itemCartRepository.findAll()).thenReturn(List.of(itemCart, itemCartTwo));
        List<ItemCartDto> items = itemCartService.getAll();
        //Then
        assertEquals(items.size(), 2);
        verify(itemCartRepository).findAll();
    }

    @Test
    void save_item_cart(){
        //Given
        itemCart.setVersion(1l);
        //When
//        when(itemCartDto.getItemCart()).thenReturn(itemCart);
        when(itemCartRepository.save(itemCart)).thenReturn(itemCart);
        ItemCartDto saveItem = itemCartService.save(itemCartDto);
        //Then
        assertEquals(saveItem.getVersion(), 1L);
//        verify(itemCartDto).getItemCart();
        verify(itemCartRepository).save(itemCart);
    }

    @Test
    void save_item_cart_list(){
        //Given
        List<ItemCart> itemCarts = List.of(itemCart,itemCartTwo);
        List<ItemCartDto> itemCartDtos = List.of(itemCartDto,itemCartDtoTwo);
        //When
        when(itemCartRepository.saveAll(itemCarts)).thenReturn(itemCarts);
        List<ItemCartDto>  saveItems = itemCartService.saveAll(itemCartDtos);
        //Then
        assertEquals(saveItems.size(), 2L);
        verify(itemCartRepository).saveAll(itemCarts);
    }

    @Test
    void update_item_cart(){
        //Given
        itemCart.setName("item 01 M");
        itemCart.setPrice(100D);
        itemCart.setVersion(2l);
        //When
        when(itemCartRepository.findById(itemCartDto.getId())).thenReturn(Optional.of(itemCart));
        when(itemCartRepository.save(itemCart)).thenReturn(itemCart);
        ItemCartDto saveItem = itemCartService.update(itemCartDto);
        //Then
        assertEquals(saveItem.getName(), itemCart.getName());
        assertEquals(saveItem.getPrice(), itemCart.getPrice());
        assertEquals(saveItem.getVersion(), itemCart.getVersion());
        verify(itemCartRepository).findById(itemCartDto.getId());
        verify(itemCartRepository).save(itemCart);
    }

    @Test
    void delete_item_cart(){
        //Given
        //When
        when(itemCartRepository.findById(1L)).thenReturn(Optional.of(itemCart));
        ItemCartDto deleteItem = itemCartService.delete(1L);
        //Then
        assertEquals(itemCart.getId(),deleteItem.getId());
        verify(itemCartRepository).delete(itemCart);
    }
}
