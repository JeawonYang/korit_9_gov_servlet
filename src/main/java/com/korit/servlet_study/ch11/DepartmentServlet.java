package com.korit.servlet_study.ch11;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.korit.servlet_study.ch11.dao.DepartmentDao;
import com.korit.servlet_study.ch11.entity.Department;
import com.korit.servlet_study.ch11.service.DepartmentService;
import com.korit.servlet_study.ch11.util.DBConnectionMgr;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/departments")
public class DepartmentServlet extends HttpServlet {
    private DepartmentService departmentService;
    private ObjectMapper objectMapper;

    @Override
    public void init() throws ServletException {
        DBConnectionMgr dbConnectionMgr = DBConnectionMgr.getInstance();
        DepartmentDao departmentDao = new DepartmentDao(dbConnectionMgr);
        departmentService = new DepartmentService(departmentDao);
        objectMapper = new ObjectMapper();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Department> departments = departmentService.getDepartments();
        objectMapper.writeValue(resp.getWriter(),departments);
    }

    // 싱글톤 - 하나의 객체만 사용할 때
    // 다른 곳에서 쓰려면 getinstance() 로만 가져올 수 있음
    // 예를 들어, 프로젝트에서 레포지토리는 하나만 필요 -> 싱글톤으로 만들어야함
    // 레포지토리는 DB 역할임
    // 싱글톤 객체는 다른 곳에서 생성되면 안되서 접근제한자 private 걸어줘야하고
    // getinstance() 로 가져오는 게 유일한 사용방법임....

}
