/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceApp;

import com.threeguys.entites.Car;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 *
 * @author noorr
 */
@WebService
public interface ICar {
    
    @WebMethod
    @WebResult(name="allCars")
    public List<Car> getAllCars();
  
    @WebMethod
    @WebResult(name="insertCar")
    public Boolean insertCar(String brand, String model, String engine, String transmission, 
            int year, int price, String filename, byte[] image);
    
    @WebMethod
    @WebResult(name="editCar")
    public Boolean editCar(String brand, String model, String engine, String transmission, 
            int year, int price, String filename, byte[] image);
    
    @WebMethod
    @WebResult(name="deleteCar")
    public Boolean deletetCar(int id);
}
