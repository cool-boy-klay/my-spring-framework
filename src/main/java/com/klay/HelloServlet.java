package com.klay;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j


@WebServlet("/hello")
public class HelloServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {

        String name = "我的框架";
        log.debug("debug test");
        httpServletRequest.setAttribute("name",name);
        httpServletRequest.getRequestDispatcher("WEB-INF/jsp/hello.jsp").forward(httpServletRequest,httpServletResponse);
    }
}
