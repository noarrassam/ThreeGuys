/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import interfaceapp.Car;
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
                + "<th>Price</th><th>Filename</th><th>Image</th>";

        for (Car offer : offers) {
            table += "<tr><td>" + offer.getId() + "</td>"
                    + "<td>" + offer.getBrand() + "</td>"
                    + "<td>" + offer.getModel() + "</td>"
                    + "<td>" + offer.getEngine() + "</td>"
                    + "<td>" + offer.getTransmission() + "</td>"
                    + "<td>" + offer.getYear() + "</td>"
                    + "<td>" + offer.getPrice() + "</td>"
                    + "<td>" + offer.getFilename() + "</td>"
                    + "<td>" + offer.getImage() + "</td>";
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
