/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.threeguys.controllers.cars;

import Helper.ConvHtml;
import Helper.XMLHelper;
import interfaceapp.Cars;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.CarsImpService;
import services.ICars;

/**
 *
 * @author noorr
 */
@WebServlet(name = "CarServlet", urlPatterns = {"/CarServlet"})
public class CarServlet extends HttpServlet {

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
            out.println("<title>Servlet CarServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CarServlet at " + request.getContextPath() + "</h1>");
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
       //get parameter from request
        String description = request.getParameter("search");
        
        //web service client, call method to search offers
        CarsImpService service = new CarsImpService();
        
        ICars port = service.getCarsImpPort();
        List<Cars> carsList = port.getAllCars();
        
        response.setContentType("text/html;charset=UTF-8");
        
        try {
            PrintWriter out = response.getWriter();
            out.println(ConvHtml.GetHtml(carsList, "Cars List"));
            
            out.println("<br/>");
            out.println("<a href='javascript:history.back()'>Go Back</a>");
            
            XMLHelper helper = new XMLHelper();
            helper.saveFile(carsList);
            
        } catch (Exception e){
            e.printStackTrace();
        }
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
//        CarsImpService service = new CarsImpService();
//        ICars port = service.getCarsImpPort();
//        List<Cars> statList = port.getAllCars();
//        
//        response.setContentType("text/html;charset=UTF-8");
//        
//        try {
//            PrintWriter out = response.getWriter();
//            out.println(ConvHtml.GetStatHtml(statList, "Statistics"));
//            
//            out.println("<br/>");
//            
//            out.println("<a href='javascript:history.back()'>Go Back</a>");
//            
//            XMLHelper helper = new XMLHelper();
//            helper.saveStatFile(statList);
//            
//        } catch (Exception e){
//            e.printStackTrace();
//        }
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
