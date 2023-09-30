package com.cloudnative.itemcart.entity;

import com.cloudnative.itemcart.dto.ItemCartDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "item_cart")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of={"id", "name"})
public class ItemCart {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_cart_gen")
    @SequenceGenerator(name = "item_cart_gen", sequenceName = "item_cart_seq")
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column( nullable = false)
    private double price;
    @Version
    private long version;
}
