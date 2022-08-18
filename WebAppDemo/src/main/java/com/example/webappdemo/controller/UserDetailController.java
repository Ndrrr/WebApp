package com.example.webappdemo.controller;

import com.example.webappdemo.util.UserUtil;
import dao.concrete.UserDao;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "userDetailController", value = "/user")
public class UserDetailController extends HttpServlet {

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
        User u;
        try{
            u = UserUtil.getUserFromRequest(req,resp);
            req.setAttribute("user",u);
            req.getRequestDispatcher("user.jsp").forward(req, resp);
        }
        catch (Exception e){
            resp.sendRedirect("error?msg=" + e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("action").equals("update")){
            updateUser(req, resp);
        }

    }
    private void updateUser(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");

        User user = userDao.get(id);
        user.setName(name);
        user.setEmail(email);
        user.setPhone(phone);
        userDao.update(user);

        String redirectUrl = "user?id="+id;
        String ref = req.getHeader("Referer");
        String[] refArr = ref.split("/");
        ref = refArr[refArr.length-1];
        if(ref.startsWith("user") && !ref.startsWith("users")){
            redirectUrl+="&success=true";
        }
        resp.sendRedirect(redirectUrl);

    }
}