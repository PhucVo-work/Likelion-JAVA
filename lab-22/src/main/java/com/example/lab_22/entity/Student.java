package com.example.lab_22.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "students")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    private String id;
    private String name;
    private String phone;
    private String email;
    private String address;
}
