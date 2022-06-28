package com.fis.OrderManagementSystem.model;

import com.fis.OrderManagementSystem.model.mum.OrderStatus;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "tbl_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="order_datetime",nullable = false)
    private LocalDateTime orderDateTime;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;

    @Column(name="total_amount",nullable = false)
    private Double totalAmount;

    @Column(name="status")
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

}
