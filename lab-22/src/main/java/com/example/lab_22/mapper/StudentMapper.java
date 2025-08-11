package com.example.lab_22.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.example.lab_22.dto.StudentDto;
import com.example.lab_22.entity.Student;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentDto toDto(Student student);

    Student toEntity(StudentDto studentDto);

    List<StudentDto> toDtoList(List<Student> students);

    void updateEntityFromDto(StudentDto Dto, @MappingTarget Student entity);
}
