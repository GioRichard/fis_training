package com.fis.OrderManagementSystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tbl_order_item")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="order_id", nullable = false)
    @JsonBackReference
    private Order order;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

    @Column(name="quantity",nullable = false)
    private Integer quantity;

    @Column(name="amount",nullable = false)
    private Double amount;

}
