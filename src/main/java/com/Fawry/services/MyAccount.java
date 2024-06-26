package com.Fawry.services;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/MyAccount")
public class MyAccount extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie=new Cookie("MyAccount",req.getParameter("MyAccount"));
        resp.addCookie(cookie);
        resp.sendRedirect(req.getContextPath() + "/Home");

    }
}
