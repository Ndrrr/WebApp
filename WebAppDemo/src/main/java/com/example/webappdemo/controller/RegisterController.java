package com.example.webappdemo.controller;

import dao.concrete.UserDao;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@WebServlet(name = "registerController", value = "/register")
public class RegisterController extends HttpServlet {

    private UserDao userDao = new UserDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            req.getRequestDispatcher("register.jsp").forward(req, resp);
        }
        catch (Exception e){
            resp.sendRedirect("error?msg=" + e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equals("register")) {
            register(req, resp);
        }
    }

    private void register(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String passwordConfirm = req.getParameter("password_confirm");
        System.out.println(email + " " + password + " " + passwordConfirm);
        List<User> users = userDao.getAll();
        AtomicReference<User> user = new AtomicReference<>(null);
        if(email!=null)
            users.stream().filter(u -> u.getEmail().equals(email)).findFirst().ifPresent(u -> {
                user.set(u);
            });
        User newUser = user.get();
        if(newUser==null && password!=null && password.equals(passwordConfirm)){
            newUser = new User(-1, email, password);
            userDao.create(newUser);
            req.getSession().setAttribute("user", newUser);
            resp.sendRedirect("users");
        }
        else if(!password.equals(passwordConfirm))
            resp.sendRedirect("register?msg=check passwords");
        else if(newUser!=null)
            resp.sendRedirect("register?msg=email already exists");
        else {
            resp.sendRedirect("register?msg=fill all fields");
        }
    }

}