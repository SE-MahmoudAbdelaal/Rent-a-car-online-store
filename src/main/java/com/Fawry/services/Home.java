package com.Fawry.services;

import com.Fawry.dao.CarDAOImp;
import com.Fawry.db.DBConnection;
import com.Fawry.entity.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/Home")
public class Home extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CarDAOImp carDAOImp = new CarDAOImp();
        List<Car> cars = carDAOImp.findAll();

        // Store the result set in a request attribute
        req.setAttribute("cars", cars);

        // Forward the request to the JSP page
            req.getRequestDispatcher("/webapp/Home.jsp").forward(req, resp);

        }
    }


