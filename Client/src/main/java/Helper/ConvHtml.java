/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import interfaceapp.Car;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import services.CarImpService;
import services.ICar;

/**
 *
 * @author noorr
 */
public class ConvHtml {

    public static String GetHtml(List<Car> offers, String title) {
        String table = "<h1>" + title + "</h1>";
        table += "<table border='1'><tr><th>ID</th><th>Brand</th><th>Model</th>"
                + "<th>Engine</th></th><th>Transmission</th></th><th>Year</th></th>"
                + "<th>Price</th><th>Image</th>";

        for (Car offer : offers) {
            System.out.println("img data: " + Arrays.toString(offer.getImage()));
            ByteArrayInputStream bis = new ByteArrayInputStream(offer.getImage());
            File img = null;
            try {
                BufferedImage bim = ImageIO.read(bis);
                System.out.println("Helper.ConvHtml.GetHtml()" + bim.getHeight() + " : " + bim.getWidth());
                img = new File(offer.getFilename());
                ImageIO.write(bim, offer.getFilename().substring(offer.getFilename().lastIndexOf(".") + 1), img);
                System.out.println("img file: " + img.exists() + img.getAbsolutePath());
            } catch (IOException ex) {
                Logger.getLogger(ConvHtml.class.getName()).log(Level.SEVERE, null, ex);

            }

            String base64 = Base64.getEncoder().encodeToString(offer.getImage());

            table += "<tr><td>" + offer.getId() + "</td>"
                    + "<td>" + offer.getBrand() + "</td>"
                    + "<td>" + offer.getModel() + "</td>"
                    + "<td>" + offer.getEngine() + "</td>"
                    + "<td>" + offer.getTransmission() + "</td>"
                    + "<td>" + offer.getYear() + "</td>"
                    + "<td>" + offer.getPrice() + "</td>"
                    + "<td>" + "<img src=\"data:image/jpg;base64," + base64 + "\" width=\"180px\" height=\"100px\"/></td>";
        }
        table += "</table>";

        return table;
    }

    // return the car object 
    public static Car getCarDataById(String id) {
        CarImpService service = new CarImpService();
        ICar port = service.getCarImpPort();
        List<Car> carList = port.getCar(id);

        return (Car) carList;
    }
}
