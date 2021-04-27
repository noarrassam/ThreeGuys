/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.threeguys.controllers.CarJpaController;
import com.threeguys.entites.Car;
import java.util.List;
import javax.jws.WebService;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author noorr
 */
@WebService(endpointInterface = "interfaceApp.ICar")
public class CarImp {
    
    public List<Car> getAllCars() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my_persistence_unit");
        CarJpaController car = new CarJpaController(emf);
        return car.getAllCars();
    }
    
    public Boolean insertCar(String brand, String model, String engine, String transmission, 
            int year, int price, String filename, byte[] image) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my_persistence_unit");
        CarJpaController carRepo = new CarJpaController(emf);
        
        Car car = new Car();
        car.setBrand(brand);
        car.setModel(model);
        car.setEngine(engine);
        car.setTransmission(transmission);
        car.setYear(year);
        car.setPrice(price);
        car.setFilename(filename);
        car.setImage(image);
    
        carRepo.create(car);
        
        return true;
    }
    
    public Boolean editCar(String brand, String model, String engine, String transmission, 
            int year, int price, String filename, byte[] image) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my_persistence_unit");
        CarJpaController carRepo = new CarJpaController(emf);
        
        Car car = new Car();
        car.setBrand(brand);
        car.setModel(model);
        car.setEngine(engine);
        car.setTransmission(transmission);
        car.setYear(year);
        car.setPrice(price);
        car.setFilename(filename);
        car.setImage(image);

        carRepo.edit(car);
        
        return true;
    }    
    
    public Boolean deletetCar(int id) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my_persistence_unit");
        CarJpaController carRepo = new CarJpaController(emf);
        
        Car car = new Car();
        car.setId(id);
        
        carRepo.destroy(id);
        
        return true;
    }
}
