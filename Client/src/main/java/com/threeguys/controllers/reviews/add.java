/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.threeguys.controllers.reviews;


import com.threeguys.services.Reviews;
import java.io.IOException;
import com.threeguys.services.ReviewsServ;
import com.threeguys.services.ReviewsServ_Service;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "add", urlPatterns = {"/reviews/add"})
public class add extends HttpServlet {

    
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
        request.setAttribute("action", "add");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/reviews/form.jsp");
        dispatcher.forward(request, response);
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
        request.setAttribute("action", "add");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/reviews/form.jsp");
        
        
        
        
        Reviews newReview = new Reviews();

        //Request Verification (within Model for clean code)
//                request.setAttribute("errName", newSupplier.setName(request.getParameter("name")));
//                request.setAttribute("errContact", newSupplier.setContact(request.getParameter("contact")));
//                request.setAttribute("errTelephone", newSupplier.setTelephone(request.getParameter("telephone")));
//                request.setAttribute("errComments", newSupplier.setComments(request.getParameter("comments")));

        request.setAttribute("model",newReview);

//        if (newReview.hasError()) {
//                request.setAttribute("ErrCtlMsg", "Supplier Adding Error");
//        } else {
                
        try {
            ReviewsServ port = service.getReviewsServPort();
            boolean isAdded = port.createNew(Integer.parseInt(request.getParameter("carID")), Integer.parseInt(request.getParameter("carID")), request.getParameter("title"), request.getParameter("description"), Integer.parseInt(request.getParameter("rating")));
        } catch (Exception ex) {
            // TODO handle custom exceptions here

        } 
                
                //request.setAttribute("SucCtlMsg", "Supplier Added Successfully");
        
        List<Reviews> result = new ArrayList<Reviews>();        
        try {
            ReviewsServ port = service.getReviewsServPort();
            result = port.getList();
        } catch (Exception ex) {
            // TODO handle custom exceptions here

        } 
                request.setAttribute("list", result);
                dispatcher = request.getRequestDispatcher("/reviews/table.jsp");
                // TODO redirect to Details
                //
       // }

        dispatcher.forward(request, response);
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
