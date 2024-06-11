package com.Fawry.services;

import com.Fawry.dao.CarDAOImp;
import com.Fawry.entity.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/CarFindOne")
public class CarFindOneServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
int carID=Integer.parseInt(req.getParameter("carId"));
        CarDAOImp carDAOImp=new CarDAOImp();
       Car car= carDAOImp.findByID(carID);
        List<Car> cars = carDAOImp.findAll();
        req.setAttribute("cars", cars);
        req.setAttribute("car", car);
        req.getRequestDispatcher("/webapp/Update.jsp").include(req,resp);


    }
}
