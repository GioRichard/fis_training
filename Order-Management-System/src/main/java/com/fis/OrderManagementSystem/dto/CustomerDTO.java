package com.fis.OrderManagementSystem.dto;

import com.fis.OrderManagementSystem.model.Customer;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDTO {
    private Long id;
    private String name;
    private String mobile;
    private String address;

    public static class Mapper{
        public static CustomerDTO fromEntity(Customer customer){
            return CustomerDTO.builder()
                    .id(customer.getId())
                    .name(customer.getName())
                    .mobile(customer.getMobile())
                    .address(customer.getAddress())
                    .build();
        }
    }
}
