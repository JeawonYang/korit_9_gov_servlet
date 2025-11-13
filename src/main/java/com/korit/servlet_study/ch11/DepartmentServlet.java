package com.korit.servlet_study.ch11;

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

@WebServlet("department")
public class DepartmentServlet extends HttpServlet {
    private DepartmentService departmentService;

    @Override
    public void init() throws ServletException {
        DBConnectionMgr dbConnectionMgr = DBConnectionMgr.getInstance();
        DepartmentDao departmentDao = new DepartmentDao(dbConnectionMgr);
        departmentService = new DepartmentService(departmentDao);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Department> departmentS = DepartmentService.getdepartments();
    }
}
