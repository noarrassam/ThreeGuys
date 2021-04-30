/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.threeguys.controllers.reviews;

import com.threeguys.services.ReviewsServ;
import com.threeguys.services.ReviewsServ_Service;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author mint
 */
@WebServlet(name = "editReview", urlPatterns = {"/editReview"})
public class Edit extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/WebService/ReviewsServ.wsdl")
    private ReviewsServ_Service service;
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("/details.jsp");
        try {
            
           
            ReviewsServ port = service.getReviewsServPort();
            boolean isAdded = port.update(Integer.parseInt(request.getParameter("reviewID")),
                                            request.getParameter("title"),
                                            request.getParameter("description"), 
                                            Integer.parseInt(request.getParameter("rating")));
                   
            
             request.getSession().setAttribute("SucCtlMsg", "Review Updated Successfully");
             response.sendRedirect("./details?id=" + request.getParameter("id"));    
            
            } catch (Exception ex) {
                
                
                
                request.getSession().setAttribute("ErrCtlMsg", ex.getMessage());
                response.sendRedirect("./details?id=" + request.getParameter("id"));    

            } 
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
