package com.fis.OrderManagementSystem.model;

import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_customer")
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name",nullable = false, length = 100)
    private String name;

    @Column( name="mobile",nullable = false,unique = true, length = 10)
    private String mobile;

    @Column(name="address",nullable = false, length = 100)
    private String address;
}
