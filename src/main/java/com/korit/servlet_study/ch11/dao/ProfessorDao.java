package com.korit.servlet_study.ch11.dao;

import com.korit.servlet_study.ch11.entity.Professor;
import com.korit.servlet_study.ch11.util.DBConnectionMgr;
import lombok.RequiredArgsConstructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class ProfessorDao {
    private final DBConnectionMgr mgr;

    public List<Professor> findAll() {
        List<Professor> professors = new ArrayList<>();

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = mgr.getConnection();
            String sql = """
                    SELECT
                        Professor_id,
                        Professor_name
                    FROM
                        Professor_tb
                    ORDER BY
                        Professor_id
                    """;
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Professor professor = Professor.builder()
                        .professorId(rs.getInt("professor_id"))
                        .professorName(rs.getString("professor_name"))
                        .build();
                professors.add(professor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mgr.freeConnection(con, ps, rs);
        }
        return professors;
    }
}
