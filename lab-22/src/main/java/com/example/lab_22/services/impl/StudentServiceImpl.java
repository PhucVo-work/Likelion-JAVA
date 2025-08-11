package com.example.lab_22.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.lab_22.dto.StudentDto;
import com.example.lab_22.entity.Student;
import com.example.lab_22.exception.ResourceNotFoundException;
import com.example.lab_22.mapper.StudentMapper;
import com.example.lab_22.repository.StudentRepository;
import com.example.lab_22.services.StudentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Override
    public StudentDto create(StudentDto dto) {
        Student student = studentMapper.toEntity(dto);
        return studentMapper.toDto(studentRepository.save(student));
    }

    @Override
    public StudentDto update(String id, StudentDto dto) {
        return studentRepository.findById(id)
                .map(existing -> {
                    studentMapper.updateEntityFromDto(dto, existing);
                    return studentMapper.toDto(studentRepository.save(existing));
                })
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
    }

    @Override
    public StudentDto getById(String id) {
        return studentRepository.findById(id)
                .map(studentMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
    }

    @Override
    public List<StudentDto> getAll() {
        return studentMapper.toDtoList(studentRepository.findAll());
    }

    @Override
    @Transactional
    public void delete(String id) {
        studentRepository.findById(id)
                .ifPresentOrElse(
                        studentRepository::delete,
                        () -> {
                            throw new ResourceNotFoundException("Student not found with id: " + id);
                        });
    }
}
