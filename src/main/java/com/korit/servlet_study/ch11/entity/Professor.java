package com.korit.servlet_study.ch11.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class Professor {
    private int professorId;
    private String professorName;
}
