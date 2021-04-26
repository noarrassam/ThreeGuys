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
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.swing.JOptionPane;

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

    public Boolean LoginUser(String username, String password) {

        try {
            Users use = new Users();

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("my_persistence_unit");
            EntityManager em = emf.createEntityManager();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Users> cq = cb.createQuery(Users.class);
            Root<Users> root = cq.from(Users.class);
            cq.where(
                    cb.equal(root.get("username"), username),
                    cb.equal(root.get("password"), password)
            );

            TypedQuery<Users> q = em.createQuery(cq);
            Users login = q.getSingleResult();

            if (login != null && login.getUsername() != null) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
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
