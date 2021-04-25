/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceApp;

import com.threeguys.entites.Users;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 *
 * @author noorr
 */
@WebService
public interface IUser {

    @WebMethod
    @WebResult(name = "allAuth")
    public List<Users> GetAllUsers();

    @WebMethod
    @WebResult(name = "insertAuth")
    public Boolean InsertUser(String fname, String lname, String pass, String username);

    @WebMethod
    @WebResult(name = "editAuth")
    public Boolean EdittUser(int id, String fname, String lname, String pass, String username);
    
    @WebMethod
    @WebResult(name = "editAuth")
    public Boolean LoginUser(int id, String username, String pass);
}
