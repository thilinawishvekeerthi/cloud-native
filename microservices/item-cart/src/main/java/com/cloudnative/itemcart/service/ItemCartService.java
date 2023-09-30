package com.cloudnative.itemcart.service;

import com.cloudnative.itemcart.dto.ItemCartDto;

import java.util.List;

public interface ItemCartService {
   ItemCartDto get(long id);
   List<ItemCartDto> getAll();
   ItemCartDto save(ItemCartDto itemCartDto);
   List<ItemCartDto> saveAll(List<ItemCartDto> itemCartDtos);
   ItemCartDto update(ItemCartDto itemCartDto);
   ItemCartDto delete(long id);
}
