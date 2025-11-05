package com.korit.servlet_study.ch07;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Builder
@AllArgsConstructor

public class BoardRepository {
   private static BoardRepository instance;
   private List<Board> boards;
   private String title;
   private String content;
   private String writer;

   private BoardRepository() {
       boards = new ArrayList<>();
   }

   public static BoardRepository getInstance() {
       if (Objects.isNull(instance)) {
           instance = new BoardRepository();
       }
       return instance;
   }
   public void insert(Board board) {
       board.setTitle(title);
       board.setContent(content);
       board.setWriter(writer);
       boards.add(board);
   }
   public List<Board> findAll() {
       return boards;
   }
}
