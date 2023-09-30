package com.cloudnative.itemcart.api;

import com.cloudnative.itemcart.dto.CustomResponse;
import com.cloudnative.itemcart.dto.ItemCartDto;
import com.cloudnative.itemcart.service.ItemCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/item-cart")
@RequiredArgsConstructor
public class itemCartApi {
    private final ItemCartService itemCartService;

    @GetMapping("/{id}")
    public ResponseEntity<CustomResponse> getItemCartById(@PathVariable long id){
        return ResponseEntity.ok(new CustomResponse(itemCartService.get(id)));
    }

    @GetMapping("/list")
    public ResponseEntity<CustomResponse> getAllItemCarts(){
        return ResponseEntity.ok(new CustomResponse(itemCartService.getAll()));
    }

    @PostMapping
    public ResponseEntity<CustomResponse> saveItemCart(@RequestBody ItemCartDto itemCartDto){
        return ResponseEntity.ok(new CustomResponse(itemCartService.save(itemCartDto)));
    }

    @PostMapping("/list")
    public ResponseEntity<CustomResponse> saveItemCarts(@RequestBody List<ItemCartDto> itemCartDtoList){
        return ResponseEntity.ok(new CustomResponse(itemCartService.saveAll(itemCartDtoList)));
    }

    @PutMapping
    public ResponseEntity<CustomResponse> updateItemCart(@RequestBody ItemCartDto itemCartDto){
        return ResponseEntity.ok(new CustomResponse(itemCartService.update(itemCartDto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CustomResponse> deleteItemCart(@PathVariable long id){
        return ResponseEntity.ok(new CustomResponse(itemCartService.delete(id)));
    }
}
