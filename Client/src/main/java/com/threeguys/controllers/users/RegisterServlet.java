/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.threeguys.controllers.users;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.IUser;
import services.UsersImpService;

/**
 *
 * @author noorr
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {

        @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
//        //get parameter from request
//        String description = request.getParameter("search");
//        
//        //web service client, call method to search offers
//        CarsServicesService service = new CarsServicesService();
//        ICarServ port = service.getCarsServicesPort();
//        List<Offers> offerList = port.searchCarServices(description);
//        
//        response.setContentType("text/html;charset=UTF-8");
//        
//        try {
//            PrintWriter out = response.getWriter();
//            out.println(ConvHtml.GetHtml(offerList, "Offer List"));
//            
//            out.println("<br/>");
//            out.println("<a href='javascript:history.back()'>Go Back</a>");
//            
//            XMLHelper helper = new XMLHelper();
//            helper.saveFile(offerList);
//            
//        } catch (Exception e){
//            e.printStackTrace();
//        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        //String confirmPass = request.getParameter("password");
        
        UsersImpService service = new UsersImpService();
        IUser port = service.getUsersImpPort();
        Boolean offerList = port.insertUser(fname, lname, password, userName);
        
        //RegisterBean registerBean = new RegisterBean();

        if (offerList.equals("SUCCESS")) //On success, you can display a message to user on Home page
        {
            request.getRequestDispatcher("/Home.jsp").forward(request, response);
        } else //On Failure, display a meaningful message to the User.
        {
            request.setAttribute("errMessage", offerList);
            request.getRequestDispatcher("/Register.jsp").forward(request, response);
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