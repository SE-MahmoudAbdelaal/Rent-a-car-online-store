package com.Fawry.services;

import com.Fawry.dao.CarDAOImp;
import com.Fawry.entity.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

@WebServlet("/updateCar")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10,      // 10MB
        maxRequestSize = 1024 * 1024 * 50    // 50MB
)
public class UpdateCar extends HttpServlet {
    private static final String UPLOAD_DIR = "resources" + File.separator + "images";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String applicationPath = req.getServletContext().getRealPath("");
        String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;
        File fileSaveDir = new File(uploadFilePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdirs();
        }
        String fileName = "";
        for (Part part : req.getParts()) {
            if (part.getName().equals("productImage")) {
                // Extracts file name from HTTP header content-disposition
                fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
                // Saves the file on disk
                part.write(uploadFilePath + File.separator + fileName);
            }
        }
        int carId = Integer.parseInt(req.getParameter("carId"));
        String CarName = req.getParameter("productName");
        String CarPrice = req.getParameter("productPrice");
        String CarDescription = req.getParameter("productDescription");
        String CarImagePath = UPLOAD_DIR + File.separator + fileName;

        // Default value if CarPrice is empty or null
        int price = 0;
        if (CarPrice != null && !CarPrice.isEmpty()) {
            try {
                price = Integer.parseInt(CarPrice);
            } catch (NumberFormatException e) {
                // Handle the case where CarPrice is not a valid integer
                e.printStackTrace();
            }
        }

        Car car = new Car(CarName, price, CarDescription, CarImagePath);
        car.setId(carId);
        CarDAOImp carDAOImp = new CarDAOImp();
        System.out.println(car);
        carDAOImp.update(car);
        resp.sendRedirect(req.getContextPath() + "/Home");
    }
}
