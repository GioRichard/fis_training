package com.fis.OrderManagementSystem.model.mum;

public enum OrderStatus {
    CREATED, /* Trang thai da khoi tao thanh cong*/
    WAITING_APPROVAL, /* Trang thai cho phe duyet*/
    PAID, /* Trang thai da thanh toan thanh cong */
    CANCELLED /*Order da bi Huy*/
}
