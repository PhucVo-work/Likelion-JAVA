package com.example.lab_22.services;

import java.util.List;

import com.example.lab_22.dto.StudentDto;

public interface StudentService {
    StudentDto create(StudentDto dto);

    StudentDto update(String id, StudentDto dto);

    StudentDto getById(String id);

    List<StudentDto> getAll();

    void delete(String id);
}