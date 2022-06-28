package com.fis.OrderManagementSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QueryOrderDTO {
    private  Long customerId;
    private Double amountGreaterThan;
    private LocalDateTime orderDateGreaterThan;
}
