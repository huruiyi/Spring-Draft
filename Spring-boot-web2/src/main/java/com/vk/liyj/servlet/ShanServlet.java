package com.vk.liyj.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 带 @WebServlet注解的Servlet注册需要@ServletComponentScan注解的扫描
 */
@WebServlet(urlPatterns = "/jeff/*")
public class ShanServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println(">>>>>>>>>>ShanServlet.doGet()<<<<<<<<<<<");
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println(">>>>>>>>>>ShanServlet.doPost()<<<<<<<<<<<");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello World</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>hello,my nam is shanServlet</h1>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }

}
