package com.example.webappdemo.controller;

import com.example.webappdemo.util.UserUtil;
import dao.concrete.UserDao;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "userController", value = "/users")
public class UserController extends HttpServlet {

    private UserDao userDao = new UserDao();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(!UserUtil.isUserLoggedIn(req, resp))
            resp.sendRedirect("login?msg=You must be logged in to view this page");
        else
            super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            req.getRequestDispatcher("users.jsp").forward(req, resp);
        }
        catch (Exception e){
            resp.sendRedirect("error?msg=" + e.getMessage());
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equals("delete")) {
            deleteUser(req, resp);
        }
    }
    private void deleteUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        if(id!=null)
            userDao.delete(id);
        resp.sendRedirect("users");
    }
}