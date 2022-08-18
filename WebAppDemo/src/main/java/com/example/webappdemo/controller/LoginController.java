package com.example.webappdemo.controller;

import dao.concrete.UserDao;
import model.User;

import java.io.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "loginController", value = "/login")
public class LoginController extends HttpServlet {

    private UserDao userDao = new UserDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
        catch (Exception e){
            resp.sendRedirect("error?msg=" + e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equals("login")) {
            login(req, resp);
        }
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        List<User> users = userDao.getAll();
        AtomicReference<User> user = new AtomicReference<>(null);
        if(email!=null && password!=null)
            users.stream().filter(u -> u.getEmail().equals(email) && u.getPassword().equals(password)).findFirst().ifPresent(u -> {
                user.set(u);
                HttpSession session = req.getSession();
                session.setAttribute("user", u);
            });
        if(user.get()==null)
            resp.sendRedirect("login?msg=Invalid email or password");
        else
            resp.sendRedirect("users");
    }

}