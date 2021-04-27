package Helper;

import interfaceapp.Cars;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 *
 * Helper method to generate the XML
 *
 * @author noorr
 */
public class XMLHelper {

    public void saveFile(List<Cars> cars) throws FileNotFoundException {
        try {

            CarsList list = new CarsList();
            list.setCars(cars);

            JAXBContext jaxbContext = JAXBContext.newInstance(CarsList.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            //Print XML String to Console
            File file = new File("C:\\Users\\noorr\\Documents\\NetBeansProjects\\CarsWebServiceClient\\src\\test\\" + String.valueOf(System.currentTimeMillis()) +
                    ".xml");
            
            System.out.println(file.getAbsoluteFile());
            
            
            
            jaxbMarshaller.marshal(list, file);
            
            
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
    
//    public void saveStatFile(List<Statistics> statistics) throws FileNotFoundException {
//        try {
//
//            StatisticsList list = new StatisticsList();
//            list.setStatistics(statistics);
//
//            JAXBContext jaxbContext = JAXBContext.newInstance(StatisticsList.class);
//            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
//
//            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//
//            File file = new File("C:\\Users\\noorr\\Documents\\NetBeansProjects\\CarsWebServiceClient\\src\\test\\" + String.valueOf(System.currentTimeMillis()) +
//                    ".xml");
//            jaxbMarshaller.marshal(list, file);
//            
//            System.out.println("File SAVED: " + file.getAbsoluteFile());
//
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }
//    }
}