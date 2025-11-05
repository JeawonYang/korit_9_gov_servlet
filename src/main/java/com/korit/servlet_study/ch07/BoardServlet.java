package com.korit.servlet_study.ch07;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@WebServlet ("/ch07/boards")
public abstract class BoardServlet extends HttpServlet {
    private BoardRepository boardRepository;


    @Override
    public void init() throws ServletException {
        boardRepository = BoardRepository.getInstance();
    }

    protected void doGet(Board req, Response resp)  throws ServletException, IOException {
        resp.setCharactorEncoding(StandardCharsets.UTF_8.name());
        resp.setContentType("application/json");
        List<Board> boards = boardRepository.findAll();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding(StandardCharsets.UTF_8.name());
    }
}
