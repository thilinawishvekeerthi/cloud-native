package com.cloudnative.itemcart.service;

import com.cloudnative.itemcart.config.exception.CustomException;
import com.cloudnative.itemcart.dto.ItemCartDto;
import com.cloudnative.itemcart.entity.ItemCart;
import com.cloudnative.itemcart.enums.CustomErrorEnum;
import com.cloudnative.itemcart.repo.ItemCartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemCartServiceImpl implements ItemCartService{


    private final ItemCartRepository itemCartRepository;

    @Override
    public ItemCartDto get(long id) {
        return mapEntitytoDto(itemCartRepository.findById(id)
                .orElseThrow(()->new CustomException(CustomErrorEnum.ERROR_C01,"Cannot find item cart id :"+id)));
    }

    @Override
    public List<ItemCartDto> getAll() {
        return itemCartRepository.findAll()
                .stream()
                .map(itemCart ->mapEntitytoDto(itemCart)).collect(Collectors.toList());
    }

    @Override
    public ItemCartDto save(ItemCartDto itemCartDto) {
        return mapEntitytoDto(itemCartRepository.save(mapDtoToEntity(itemCartDto)));
    }

    @Override
    public List<ItemCartDto> saveAll(List<ItemCartDto> itemCartDtos) {
        return itemCartRepository
                .saveAll(itemCartDtos.stream().map(itemCartDto ->mapDtoToEntity(itemCartDto)).collect(Collectors.toList()))
                .stream()
                .map(itemCart -> mapEntitytoDto(itemCart))
                .collect(Collectors.toList());
    }

    @Override
    public ItemCartDto update(ItemCartDto itemCartDto) {
        ItemCart itemCart = itemCartRepository.findById(itemCartDto.getId())
                .orElseThrow(()->new CustomException(CustomErrorEnum.ERROR_C01,"Cannot find item cart id :"+itemCartDto.getId()));
        itemCart.setName(itemCartDto.getName());
        itemCart.setPrice(itemCartDto.getPrice());
        itemCartRepository.save(itemCart);
        return mapEntitytoDto(itemCart);
    }

    @Override
    public ItemCartDto delete(long id) {
        ItemCart itemCart = itemCartRepository.findById(id)
                .orElseThrow(()->new CustomException(CustomErrorEnum.ERROR_C01,"Cannot find item cart id :"+id));
        itemCartRepository.delete(itemCart);
        return mapEntitytoDto(itemCart);
    }

    private ItemCartDto mapEntitytoDto(ItemCart entity){
        ItemCartDto dto = new ItemCartDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    private ItemCart mapDtoToEntity(ItemCartDto dto){
        ItemCart entity = new ItemCart();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
}
