package com.example.webappdemo.util;

import com.mysql.cj.util.StringUtils;
import dao.concrete.UserDao;
import model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

public class UserUtil {
    public static User getUserFromRequest(HttpServletRequest req, HttpServletResponse resp) throws IllegalArgumentException {
        UserDao userDao = new UserDao();
        Integer userId = null;
        Optional<String> userIdOpt = Optional.ofNullable(req.getParameter("id"));
        User user;

        if(userIdOpt.isPresent()&& StringUtils.isStrictlyNumeric(userIdOpt.get())) {
            userId = Integer.parseInt(userIdOpt.get());
            user = userDao.get(userId);
        }
        else {
            throw new IllegalArgumentException("Invalid user id");
        }
        if(user == null)
            throw new IllegalArgumentException("Invalid user id");
        return user;
    }

    public static boolean isUserLoggedIn(HttpServletRequest req, HttpServletResponse resp) {
        return req.getSession().getAttribute("user") != null;
    }

    public static void logOut(HttpServletRequest req, HttpServletResponse resp) {
        req.getSession().removeAttribute("user");
    }
}
