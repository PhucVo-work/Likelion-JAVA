package com.example.lab_22.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.lab_22.entity.Student;

public interface StudentRepository extends MongoRepository<Student, String> {
}
