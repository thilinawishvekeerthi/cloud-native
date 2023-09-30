package com.cloudnative.itemcart.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * DTO for {@link com.cloudnative.itemcart.entity.ItemCart}
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of={"id", "name"})
public class ItemCartDto implements Serializable {
    private Long id;
    private String name;
    private double price;
    private long version;
}
