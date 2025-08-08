package com.example.theory_21_spring_data_mongodb_v2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDto {
    private String id;
    private String name;
    private String phone;
    private String email;
    private int age;
}
