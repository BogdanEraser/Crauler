package WorkWithXML;

import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

/**
 * Created by Bogdan Kukharskiy on 08.10.15.
 */
public class XMLRunner {
    public static void main(String[] args) {
        File fileXML = new File("plcs.xml");
        File fileXSD = new File("plcs_scheme.xsd");

        //проверка валидности XML файла схеме
        try {
            System.out.println("Проверка валидности XML файла схеме: " + XMLValidator.validateXMLByXSD(fileXML, fileXSD));
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
