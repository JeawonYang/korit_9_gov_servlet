package com.korit.servlet_study.ch11.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class Course {
    private int courseId;
    private String courseCode;
    private String courseName;
    private int professorId;
    private int credit;
    private int enrollmentCapacity;
}
