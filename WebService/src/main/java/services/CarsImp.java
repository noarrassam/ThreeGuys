/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.threeguys.controllers.CarsJpaController;
import com.threeguys.entites.Cars;
import java.util.List;
import javax.jws.WebService;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author noorr
 */
@WebService(endpointInterface = "interfaceApp.ICars")
public class CarsImp {
    
    public List<Cars> GetAllCars() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my_persistence_unit");
        CarsJpaController car = new CarsJpaController(emf);
        return car.getAllCars();
    }
    
    public Boolean InsertCar(String brand, String dis, String engine, String filename, byte[] image, String prm, String model, 
            int price, String transmission, String type, int year) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my_persistence_unit");
        CarsJpaController carRepo = new CarsJpaController(emf);
        
        Cars car = new Cars();
        car.setBrand(brand);
        car.setDisplacement(dis);
        car.setEngine(engine); 
        car.setFilename(filename);
        car.setImage(image);
        car.setMaxRPM(prm);
        car.setModel(model);
        car.setPrice(price);
        car.setTransmission(transmission);
        car.setType(type);
        car.setYear(year);
        
        carRepo.create(car);
        
        return true;
    }
    
    public Boolean EditCar(String brand, String dis, String engine, String filename, byte[] image, String prm, String model, 
            int price, String transmission, String type, int year) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my_persistence_unit");
        CarsJpaController carRepo = new CarsJpaController(emf);
        
        Cars car = new Cars();
        car.setBrand(brand);
        car.setDisplacement(dis);
        car.setEngine(engine); 
        car.setFilename(filename);
        car.setImage(image);
        car.setMaxRPM(prm);
        car.setModel(model);
        car.setPrice(price);
        car.setTransmission(transmission);
        car.setType(type);
        car.setYear(year);

        carRepo.edit(car);
        
        return true;
    }    
    
    public Boolean DeletetCar(int id) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my_persistence_unit");
        CarsJpaController carRepo = new CarsJpaController(emf);
        
        Cars car = new Cars();
        car.setId(id);
        
        carRepo.destroy(id);
        
        return true;
    }
}
