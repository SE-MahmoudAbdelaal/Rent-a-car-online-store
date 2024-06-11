package com.Fawry.services;

import com.Fawry.dao.CarDAOImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CarDeleteServlet")
public class CarDeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int carId = Integer.parseInt(req.getParameter("carId"));

        CarDAOImp carDAOImp=new CarDAOImp();
        System.out.println(carId);
        carDAOImp.deleteCarById(carId);
        resp.sendRedirect(req.getContextPath() + "/Home");


    }
}
