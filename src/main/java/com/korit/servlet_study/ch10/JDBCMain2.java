package com.korit.servlet_study.ch10;

import java.sql.*;

public class JDBCMain2 {
    public static void main(String[] args) {
        final String URL = "jdbc:mysql://localhost:3309/student_db";
        final String USERNAME = "root";
        final String PASSWORD = "1q2w3e4r";

        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String sql = """
                
                SELECT
                course_id,
                course_code, 
                course_name,
                professor_name, 
                credit,
                enrollment_capacity
                FROM
                    course_tb 
                    JOIN professor_tb ON professor_tb.professor_id = course_tb.professor_id
                WHERE
                    course_name = '프로그래밍언어론'                                                                          
                """;

            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            rs.next();
            int courseId = rs.getInt("course_id");
            String courseCode = rs.getString("course_code");
            String courseName = rs.getString("course_name");
            String professorName = rs.getString("professor_name");
            int credit = rs.getInt("credit");
            int enrollmentCapacity = rs.getInt("enrollment_capacity");
            System.out.println("과목ID : " + courseId);
            System.out.println("과목코드 : " + courseCode);
            System.out.println("과목명 : " + courseName);
            System.out.println("교수명 : " + professorName);
            System.out.println("학점 : " + credit);
            System.out.println("수강인원 : " + enrollmentCapacity);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("데이터베이스 연결 실패했어요.");
        }
    }
}
