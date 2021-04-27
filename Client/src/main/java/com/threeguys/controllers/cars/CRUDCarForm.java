/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.threeguys.controllers.cars;

import interfaceapp.Car;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import services.CarImpService;
import services.ICar;

/**
 *
 * @author noorr
 */
@MultipartConfig
@WebServlet(name = "CRUDCarForm", urlPatterns = {"/CRUDCarForm"})
public class CRUDCarForm extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CRUDCarForm</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CRUDCarForm at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String brand = request.getParameter("brand");
        String model = request.getParameter("model");
        String engine = request.getParameter("engine");
        String transmission = request.getParameter("transmission");
        int year = parseInt(request.getParameter("year"));
        int price = parseInt(request.getParameter("price"));

        String operation = request.getParameter("operation");

        String uploadPath = getServletContext().getRealPath("") + File.separator + "uploads";

        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        //get file
        String name = request.getPart("fileToUpload").getSubmittedFileName();
        byte[] data;
        Part file = request.getPart("fileToUpload");
        InputStream in = file.getInputStream();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        int read = 0;
        final byte[] bytes = new byte[1024];
        while ((read = in.read(bytes, 0, bytes.length)) != -1) {
            bos.write(bytes);
        }
        data = bos.toByteArray();

        CarImpService service = new CarImpService();
        ICar port = service.getCarImpPort();
        boolean filesize;

        switch (operation) {
            case "Add":
                    try {
                filesize = port.insertCar(brand, model, engine, transmission, year, price, name, data);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            break;

            case "Edit":      
            try {
                
                int id = parseInt(request.getParameter("id"));        
                filesize = port.editCar(id, brand, model, engine, transmission, year, price, name, data);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            break;

            case "Delete":
            try {
                int id = parseInt(request.getParameter("id"));
                filesize = port.deletetCar(id);
            } catch (Exception ex) {
                ex.printStackTrace(); 
            }
            break;

//                case "Search":
//                    //List<Person> persons = hiber.searchUser(request.getParameter("name"));
//                    //request.setAttribute("list", persons);
//                    request.getRequestDispatcher("home.jsp").forward(request, response);
//                    return;
            default:
                System.out.println("Error");
                break;
        }
        List<Car> listCars = port.getAllCars();
        request.setAttribute("list", listCars);
        request.getRequestDispatcher("carsTable.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
