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
      
        public Boolean InsertCar(String model, byte[] image, String year, int price, String type, String brand, String transmission, String engine, String dis, String prm) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my_persistence_unit");
        CarsJpaController carRepo = new CarsJpaController(emf);
        
        Cars car = new Cars();
        car.setModel(model);
        car.setImage(image);
        car.setYear(price);
        car.setType(type);
        car.setBrand(brand);
        car.setTransmission(transmission);
        car.setEngine(engine);
        car.setDisplacement(dis);
        car.setMaxRPM(prm);
        
        carRepo.create(car);
        
        return true;
    }
        
        public Boolean EditCar(String model, byte[] image, String year, int price, String type, String brand, String transmission, String engine, String dis, String prm) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my_persistence_unit");
        CarsJpaController carRepo = new CarsJpaController(emf);
        
        Cars car = new Cars();
        car.setModel(model);
        car.setImage(image);
        car.setYear(price);
        car.setType(type);
        car.setBrand(brand);
        car.setTransmission(transmission);
        car.setEngine(engine);
        car.setDisplacement(dis);
        car.setMaxRPM(prm);
        
        carRepo.edit(car);
        
        return true;
    }   
        
        public Boolean DeleteCar() throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my_persistence_unit");
        CarsJpaController carRepo = new CarsJpaController(emf);
        
        Cars car = new Cars();
//        car.setModel(model);
//        car.setImage(image);
//        car.setYear(price);
//        car.setType(type);
//        car.setBrand(brand);
//        car.setTransmission(transmission);
//        car.setEngine(engine);
//        car.setDisplacement(dis);
//        car.setMaxRPM(prm);
        
        carRepo.create(car);
        
        return true;
    }
}

