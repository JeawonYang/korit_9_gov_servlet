package com.korit.servlet_study.ch11.service;

import com.korit.servlet_study.ch11.dao.ProfessorDao;
import com.korit.servlet_study.ch11.entity.Professor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ProfessorService {
    private final ProfessorDao professorDao;

    public List<Professor> getprofessors(){
        return professorDao.findAll();
    }
}
