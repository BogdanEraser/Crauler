package WorkWithXML;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created by Bogdan Kukharskiy on 06.10.2015.
 */
public class XMLValidator {

    public boolean isValid() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(true);
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document document = null;

//        SchemaFactory factory =
//                SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
//        Schema schema = factory.newSchema(new StreamSource(pathXsd));
//        Validator validator = schema.newValidator();
//        validator.validate(new StreamSource(pathXml));

        try {
            document = builder.parse("plcs.xml");
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if document.
        return true;
    }
}
