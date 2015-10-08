package WorkWithXML;

import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

/**
 * Created by Bogdan Kukharskiy on 08.10.15.
 */
public class XMLRunner {
    public static void main(String[] args) {
        File fileXML = new File("D:\\Java\\com\\SourceIT\\Crauler\\src\\main\\java\\WorkWithXML\\plcs.xml");
        File fileXSD = new File("D:\\Java\\com\\SourceIT\\Crauler\\src\\main\\java\\WorkWithXML\\plcs_scheme.xsd");

        try {
            System.out.println("Проверка валидности XML файла схеме: " + XMLValidator.validateXMLByXSD(fileXML, fileXSD));
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
