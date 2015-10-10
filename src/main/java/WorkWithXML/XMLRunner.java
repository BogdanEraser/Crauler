package WorkWithXML;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
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

        PLC plc = new PLC();
        ObjectMapper mapper = new ObjectMapper();

        try {

            // convert user object to json string, and save to a file
            mapper.writeValue(fileXML, plc);

            // display to console
            System.out.println(mapper.writeValueAsString(plc));

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
