/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import interfaceapp.Car;
import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

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
            System.out.println("img data: "+ Arrays.toString(offer.getImage()));
            ByteArrayInputStream bis = new ByteArrayInputStream(offer.getImage());
//            File img = null;
//            try {
////                BufferedImage bim = ImageIO.read(bis);
////                System.out.println("Helper.ConvHtml.GetHtml()"+ bim.getHeight()+ " : "+ bim.getWidth());
////                img = new File(offer.getFilename());
//////                img.createNewFile();
////                ImageIO.write(bim, offer.getFilename().substring(offer.getFilename().lastIndexOf(".")+1), img);
//                System.out.println("img file: "+ img.exists()+ img.getAbsolutePath());
//            } catch (IOException ex) {
//                Logger.getLogger(ConvHtml.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            
            String base64 = Base64.getEncoder().encodeToString(offer.getImage());
            
            table += "<tr><td>" + offer.getId() + "</td>"
                    + "<td>" + offer.getBrand() + "</td>"
                    + "<td>" + offer.getModel() + "</td>"
                    + "<td>" + offer.getEngine() + "</td>"
                    + "<td>" + offer.getTransmission() + "</td>"
                    + "<td>" + offer.getYear() + "</td>"
                    + "<td>" + offer.getPrice() + "</td>"
                    + "<td>" + "<img src=\"data:image/jpg;base64,"+base64+"\" width=\"180px\" height=\"100px\"/></td>";
        }
        table += "</table>";

        return table;
    }
//
//    public static String GetStatHtml(List<Statistics> statList, String title) {
//
//        String table = "<h1>" + title + "</h1>";
//        table += "<table border='1'><tr><th>Model</th><th>Number of Services</th>";
//
//        for (Statistics stat : statList) {
//            table += "<tr><td>" + stat.getModel() + "</td>"
//                    + "<td>" + stat.getNumServices() + "</td></tr>";
//        }
//        table += "</table>";
//
//        return table;
//    }
}
