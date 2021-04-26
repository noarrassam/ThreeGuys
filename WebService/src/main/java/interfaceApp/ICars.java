/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceApp;

import com.threeguys.entites.Cars;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 *
 * @author noorr
 */
@WebService
public interface ICars {
    
    @WebMethod
    @WebResult(name="allCars")
    public List<Cars> GetAllCars(); 
    
    @WebMethod
    @WebResult(name="insertCar")
    public Boolean InsertCar(String brand, String dis, String engine, String filename, byte[] image, String prm, String model, int price, String transmission, String type, int year);
    
    @WebMethod
    @WebResult(name="editCar")
    public Boolean EditCar(String brand, String dis, String engine, String filename, byte[] image, String prm, String model, int price, String transmission, String type, int year);
    
    @WebMethod
    @WebResult(name="deleteCar")
    public Boolean DeletetCar(int id);
}
