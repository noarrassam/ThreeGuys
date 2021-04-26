/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.threeguys.controllers.UsersJpaController;
import com.threeguys.entites.Users;
import java.util.List;
import javax.jws.WebService;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author noorr
 */
@WebService(endpointInterface = "interfaceApp.IUser")
public class UsersImp {

    public List<Users> GetAllUsers() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my_persistence_unit");
        UsersJpaController user = new UsersJpaController(emf);
        return user.getAllUsers();
    }
    
    public List<Users> LoginUser(String username, String password) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my_persistence_unit");
        UsersJpaController user = new UsersJpaController(emf);
        return user.getUser(username, password);
    }

    public Boolean InsertUser(String fname, String lname, String pass, String username) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my_persistence_unit");
        UsersJpaController userRepo = new UsersJpaController(emf);

        Users user = new Users();
        user.setFname(fname);
        user.setLname(lname);
        user.setPassword(pass);
        user.setUsername(username);

        userRepo.create(user);

        return true;
    }

    public Boolean EdittUser(int id, String fname, String lname, String pass, String username) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my_persistence_unit");
        UsersJpaController userRepo = new UsersJpaController(emf);

        Users user = new Users();
        user.setFname(fname);
        user.setLname(lname);
        user.setPassword(pass);
        user.setUsername(username);

        userRepo.edit(user);

        return true;
    }
}
