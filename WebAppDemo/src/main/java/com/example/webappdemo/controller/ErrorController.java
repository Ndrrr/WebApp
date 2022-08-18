package com.example.webappdemo.controller;

import dao.concrete.UserDao;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "errorController", value = "/error")
public class ErrorController extends HttpServlet {

    private UserDao userDao = new UserDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("error.jsp").forward(req, resp);
    }

}