package WorkWithXML;

import com.fasterxml.jackson.xml.annotate.JacksonXmlElementWrapper;
import com.fasterxml.jackson.xml.annotate.JacksonXmlProperty;
import com.fasterxml.jackson.xml.annotate.JacksonXmlRootElement;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

//import org.codehaus.jackson.JsonGenerationException;
//import org.codehaus.jackson.map.JsonMappingException;
//import org.codehaus.jackson.map.ObjectMapper;
//import org.codehaus.jackson.*;
//import com.fasterxml.jackson.*;
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

        @JacksonXmlRootElement(localName = "PLCS")
        class OpenCredentials {

            @JacksonXmlProperty(localName = "plc")
            @JacksonXmlElementWrapper(useWrapping = false)
            private Credentials[] credentials;

            //getters, setters, toString
        }


        class Credentials {

            @JacksonXmlProperty(isAttribute = true)
            private String priv;

            @JacksonXmlProperty(isAttribute = true)
            private String type;

            private String user;

            @JacksonXmlProperty(localName = "client_token")
            private String clientToken;

            @JacksonXmlProperty(localName = "client_secret")
            private String clientSecret;

            //getters, setters, toString
        }

/*
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
*/


    }
}
