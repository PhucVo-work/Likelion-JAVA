package com.example.lab_22.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.lab_22.dto.StudentDto;
import com.example.lab_22.services.StudentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<StudentDto> getAll() {
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    public StudentDto getById(@PathVariable String id) {
        return studentService.getById(id);
    }

    @PostMapping
    public StudentDto create(@RequestBody StudentDto dto) {
        return studentService.create(dto);
    }

    @PutMapping("/{id}")
    public StudentDto update(@PathVariable String id, @RequestBody StudentDto dto) {
        return studentService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        studentService.delete(id);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error occurred: " + ex.getMessage());
    }
}
