package com.fis.OrderManagementSystem.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_product")
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name", nullable = false, length = 100)
    private String name;

    @Column(name="price",nullable = false)
    private Double price;

    @Column(name = "avaiable",nullable = false)
    private Long avaiable;
}
