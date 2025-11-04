package com.korit.servlet_study.ch05;

import javax.servlet.*;


public class Filter3 implements Filter {
    @Override
    public void doFilter(Request req, Response resp, FilterChain filterChain) {
        System.out.println("필터3 전처리");
        filterChain.doFilter(req, resp);
        System.out.println("필터3 전처리");
    }
}
