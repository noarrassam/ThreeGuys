/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.threeguys.controllers.cars;

import Helper.ConvHtml;
import com.threeguys.services.Reviews;
import com.threeguys.services.ReviewsServ_Service;
import interfaceapp.Car;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Base64;
import java.util.List;
import java.util.Objects;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import services.CarImpService;
import services.ICar;

/**
 *
 * @author mint
 */
@WebServlet(name = "details", urlPatterns = {"/details"})
public class CarDetails extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/WebService/ReviewsServ.wsdl")
    private ReviewsServ_Service revService;

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
        
   

      
        


           try {

            // Getting ID form request URL, Error handling if cant
            int id = Integer.parseInt(request.getParameter("id"));

            // Getting Car Service
                CarImpService service = new CarImpService();
                ICar port = service.getCarImpPort();
                Car car = port.getCarbyID(id);
            
            //Getting Comments from Service   
            com.threeguys.services.ReviewsServ Revport = revService.getReviewsServPort();
            java.util.List<com.threeguys.services.Reviews> reviews = Revport.getListByCarID(id);
            
            if(request.getSession().getAttribute("SucCtlMsg") != null) {
                request.setAttribute("SucCtlMsg", request.getSession().getAttribute("SucCtlMsg"));
                request.getSession().removeAttribute("SucCtlMsg");
            }
            
            if(request.getSession().getAttribute("ErrCtlMsg") != null) {
                request.setAttribute("ErrCtlMsg", request.getSession().getAttribute("ErrCtlMsg"));
                request.getSession().removeAttribute("ErrCtlMsg");
            }
            
            if (request.getParameter("action") != null) {
                if (request.getParameter("action").equalsIgnoreCase("edit")) {
                     request.setAttribute("action", "edit");
                    int carID = 0;
                    int reviewID = 0;
                    if (request.getParameter("reviewID") != null && request.getParameter("id") != null){
                        try{
                            carID = Integer.parseInt(request.getParameter("id"));
                            reviewID = Integer.parseInt(request.getParameter("reviewID"));
                        } catch (Exception e) {
                            throw new Exception("Error Processing ID");
                        }
                    }
                    if (carID == 0 || reviewID == 0) throw new Exception("No IDs supplied");
                    Reviews review = Revport.getListByID(reviewID);
                  //  if (review.getUserID(), request.getSession().getAttribute("uid"))) throw new Exception("Unauthorized to edit this review");
                    request.setAttribute("review", review);
                } else {
                    request.setAttribute("action", "add");
                }
                 
            } else {
                request.setAttribute("action", "add");
            }
            
            // Setting Attributes before forward to the JSP
                request.setAttribute("model", car);
                request.setAttribute("reviews", reviews);
                request.setAttribute("convimage", "<img class=\"carimage\" src=\"data:image/jpg;base64," + Base64.getEncoder().encodeToString(car.getImage()) + "\" />");
                System.out.println("com.threeguys.controllers.cars.CarDetails.processRequest(): " + car.getImage().toString());
                
             // Forwarding
                RequestDispatcher dispatcher = request.getRequestDispatcher("/details.jsp");
                dispatcher.forward(request, response);
                
                
           } catch (Exception e) {
                 response.setContentType("text/html;charset=UTF-8");
      
                 PrintWriter out = response.getWriter();
                String Message = e.getMessage();
                out.println("<p>Error: " + Message + "</p>");
                
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
        processRequest(request, response);
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
