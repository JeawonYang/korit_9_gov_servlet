package com.korit.servlet_study.ch11;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.korit.servlet_study.ch11.dao.ProfessorDao;
import com.korit.servlet_study.ch11.entity.Professor;
import com.korit.servlet_study.ch11.service.ProfessorService;
import com.korit.servlet_study.ch11.util.DBConnectionMgr;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/professors")
public class ProfessorServlet extends HttpServlet {
    private ProfessorService professorService;
    private ObjectMapper objectMapper;

    @Override
    public void init() throws ServletException {
        DBConnectionMgr dbConnectionMgr = DBConnectionMgr.getInstance();
        ProfessorDao departmentDao = new ProfessorDao(dbConnectionMgr);
        professorService = new ProfessorService(departmentDao);
        objectMapper = new ObjectMapper();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Professor> departments = professorService.getprofessors();
        objectMapper.writeValue(resp.getWriter(),departments);
    }
}
