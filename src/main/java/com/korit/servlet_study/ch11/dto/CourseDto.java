package com.korit.servlet_study.ch11.dto;

import com.korit.servlet_study.ch11.entity.Course;
import lombok.Data;

@Data
public class CourseDto {
    private String code;
    private String name;
    private int professor;
    private int credit;
    private int enrollmentCapacity;

    public Course toEntity() {
        return Course.builder()
                .courseCode(code)
                .courseName(name)
                .professorId(professor)
                .credit(credit)
                .enrollmentCapacity(enrollmentCapacity)
                .build();
    }
}
