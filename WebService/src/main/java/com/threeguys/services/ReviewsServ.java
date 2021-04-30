/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.threeguys.services;

import com.threeguys.entites.Reviews;
import com.threeguys.controllers.ReviewsJpaController;
import com.threeguys.exceptions.SOAPException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author mint
 */
@WebService(serviceName = "ReviewsServ")
public class ReviewsServ {

    @WebMethod(operationName = "getList")
    public List<Reviews> getList()  {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my_persistence_unit");
        ReviewsJpaController reviewController = new ReviewsJpaController(emf);
       
        return reviewController.findReviewsEntities();
    }
    
    @WebMethod(operationName = "getListByID")
    public Reviews getListByID(@WebParam(name = "id") int id) throws SOAPException {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my_persistence_unit");
        ReviewsJpaController reviewController = new ReviewsJpaController(emf);
       
        if (id == 0)
            throw new SOAPException("ID cannot be zero");
        
       //find review in database
        Reviews review;
             try {
                review = reviewController.findReviews(id);
                
            } catch (Exception ex) {
                Logger.getLogger(ReviewsServ.class.getName()).log(Level.SEVERE, null, ex);
               throw new SOAPException("Could not find review in Databse");
            }
             
             return review;
    }
    
    
        @WebMethod(operationName = "getListByCarID")
    public List<Reviews> getListByCarID(@WebParam(name = "id") int id) throws SOAPException {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my_persistence_unit");
        ReviewsJpaController reviewController = new ReviewsJpaController(emf);
       
        if (id == 0)
            throw new SOAPException("ID cannot be zero");
        
       //find review in database
        List<Reviews> reviews;
             try {
                reviews = reviewController.findReviewsByCarID(id);
                
            } catch (Exception ex) {
                Logger.getLogger(ReviewsServ.class.getName()).log(Level.SEVERE, null, ex);
               throw new SOAPException("Could not find review in Databse");
            }
             
             return reviews;
    }
    
   
    
    
    public List<Reviews> searchListByCarID(@WebParam(name = "id") int id, @WebParam(name = "searchWord") String word) throws SOAPException {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my_persistence_unit");
        ReviewsJpaController reviewController = new ReviewsJpaController(emf);
       
        if (id == 0)
            throw new SOAPException("ID cannot be zero");
        
       //find review in database
        List<Reviews> reviews = new ArrayList<Reviews>();
             try {
                if (word != null) {
                    if (!word.equalsIgnoreCase("")) {
                        reviews = reviewController.findReviewsByCarID(id,word);
                    } else {
                        reviews = reviewController.findReviewsByCarID(id);
                    }
                } else {
                    reviews = reviewController.findReviewsByCarID(id);
                }
                    
                
            } catch (Exception ex) {
                Logger.getLogger(ReviewsServ.class.getName()).log(Level.SEVERE, null, ex);
               throw new SOAPException("Could not find review in Databse");
            }
             
             return reviews;
    }
    
    
    
    
    @WebMethod(operationName = "createNew")
    public boolean createNew(  @WebParam(name = "userID") int userID,
                            @WebParam(name = "carID") int carID,
                            @WebParam(name = "title") String title,
                            @WebParam(name = "description") String description,
                            @WebParam(name = "rating") int rating) 
                            throws SOAPException {
        //Setting up controller
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my_persistence_unit");
        ReviewsJpaController reviewController = new ReviewsJpaController(emf);
       
        //input verification
             Reviews review = new Reviews();
             if (userID == 0)
                 throw new SOAPException("User ID cannot be zero");
             if (carID == 0)
                 throw new SOAPException("car ID cannot be zero");
             if (rating < 1 || rating > 5)
                 throw new SOAPException("Rating must be between 1-5");
             if (description == null || description.equals(""))
                 throw new SOAPException("Description is required");
             if (title == null || title.equals(""))
                 throw new SOAPException("Title is required");
             
             
        //Setting Review Details
             review.setCarID(carID);
             review.setUserID(userID);
             review.setReviewID(reviewController.getReviewsCount()+1);
             review.setTitle(title);
             review.setDescription(description);
             review.setRating(rating);
               
             
         //Saving Review into Database
            try {
                reviewController.create(review);
                return true;
            } catch (Exception ex) {
                Logger.getLogger(ReviewsServ.class.getName()).log(Level.SEVERE, null, ex);
               throw new SOAPException("Internal Reviews Controller Error");
            }
    }
    
    
     @WebMethod(operationName = "update")
    public boolean update(  @WebParam(name = "reviewID") int reviewID,
                            @WebParam(name = "title") String title,
                            @WebParam(name = "description") String description,
                            @WebParam(name = "rating") int rating) 
                            throws SOAPException {
        
        //Setting up controller
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my_persistence_unit");
        ReviewsJpaController reviewController = new ReviewsJpaController(emf);
        
        
           //Input Verification
            if (reviewID == 0)
                 throw new SOAPException("review ID cannot be zero");
             if (rating < 1 || rating > 5)
                 throw new SOAPException("Rating must be between 1-5");
             if (description == null || description.equals(""))
                 throw new SOAPException("Description is required");
             if (title == null || title.equals(""))
                 throw new SOAPException("Title is required");
        
             
            Reviews review = null;
         //find review in database
             try {
                review = reviewController.findReviews(reviewID);
                
            } catch (Exception ex) {
                Logger.getLogger(ReviewsServ.class.getName()).log(Level.SEVERE, null, ex);
               throw new SOAPException("Internal Reviews Controller Error");
            }
        
            //if review not found
            if (review == null) 
                throw new SOAPException("could not find requested review");
            
            //Updating Review Details
             review.setTitle(title);
             review.setDescription(description);
             review.setRating(rating);
               
             
            //Saving Review into Database
            try {
                reviewController.edit(review);
                return true;
            } catch (Exception ex) {
                Logger.getLogger(ReviewsServ.class.getName()).log(Level.SEVERE, null, ex);
               throw new SOAPException("Internal Reviews Controller Error");
            }
             
        
    }
    
    
     @WebMethod(operationName = "remove")
    public boolean remove(  @WebParam(name = "reviewID") int reviewID) 
                            throws SOAPException {
        
        //Setting up controller
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my_persistence_unit");
        ReviewsJpaController reviewController = new ReviewsJpaController(emf);
        
        
           //Input Verification
            if (reviewID == 0)
                 throw new SOAPException("review ID cannot be zero");
            
            
            //removing Review into Database
            try {
                reviewController.destroy(reviewID);
                return true;
            } catch (Exception ex) {
                Logger.getLogger(ReviewsServ.class.getName()).log(Level.SEVERE, null, ex);
                throw new SOAPException("could not find requested review");
            }
             
        
    }
    
}
