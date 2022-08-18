package com.example.webappdemo.controller;

import com.example.webappdemo.util.UserUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CommonServlet", value = "/common")
public class CommonServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("logout")) {
            UserUtil.logOut(request, response);
            response.sendRedirect("login");
        }

    }
}
