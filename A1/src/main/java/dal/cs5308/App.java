package dal.cs5308;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileNotFoundException;


/**
 * Created by Zongming Liu (B00784897)
 */
public class App {

    private static void usage() {
        System.out.println("Usage: java -jar target/a1-1.0-SNAPSHOT.jar <filename.xml>");
    }

    public static void main(String[] args) throws Exception {

        if (args.length != 1) {
            usage();
            return;
        }
        String filename = args[0];

        // Reference: https://docs.oracle.com/javase/tutorial/jaxp/dom/readingXML.html
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setIgnoringComments(true);
        DocumentBuilder db = dbf.newDocumentBuilder();


        Document incomingDoc = null;
        Document returnedDoc = null;
        IDOMGenerator domGenerator = new DOMGenerator();

        try {
            incomingDoc = db.parse(new File(filename));
        } catch (FileNotFoundException e) {
            System.out.println(filename + " does not exist!");
            System.exit(1);
        } catch (SAXException e) {
            returnedDoc = domGenerator.getInvalidXMLDOM();
        } finally {
            // https://docs.oracle.com/javase/tutorial/jaxp/xslt/writingDom.html
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            // https://stackoverflow.com/a/139096/8263143
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            // https://stackoverflow.com/questions/19209527/java-xml-dom-prevent-collapsing-empty-element
            transformer.setOutputProperty(OutputKeys.METHOD, "html");

            // https://stackoverflow.com/a/139096/8263143
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            if (returnedDoc == null) {
                IOrderFormatValidation orderFormatValidation = new OrderFormatValidation();
                IOrderFormatValidation.OrderFormatResponse response = orderFormatValidation.isOrderFormatValid(incomingDoc);
                if (response == IOrderFormatValidation.OrderFormatResponse.INVALID_DELIVERY_ADDRESS) {
                    returnedDoc = domGenerator.getInvalidAddressDOM();
                } else if (response == IOrderFormatValidation.OrderFormatResponse.INVALID_ORDER_ITEM_ENTRY) {
                    returnedDoc = domGenerator.getInvalidItemEntryDOM();
                } else if (response == IOrderFormatValidation.OrderFormatResponse.INVALID_ORDER_ITEM_LIST) {
                    returnedDoc = domGenerator.getInvalidItemListDOM();
                } else {

                    // authorize the dealer
                    String dealerId = incomingDoc.getElementsByTagName("dealerid").item(0).getTextContent();
                    String dealerAccessKey = incomingDoc.getElementsByTagName("dealeraccesskey").item(0).getTextContent();
                    ISecurity iSecurity = new MockSecurity();

                    if (!iSecurity.isDealerAuthorized(dealerId, dealerAccessKey)) {

                        returnedDoc = domGenerator.getUnAuthorizedDealerDOM();
                    } else {

                        // The dealer is authorized, build a document.
                        // The validation using Database and PARTMANAGER will be done in the method as well.
                        returnedDoc = domGenerator.getValidOrderDOM(incomingDoc);
                    }

                }
            }
            DOMSource domSource = new DOMSource(returnedDoc);
            StreamResult streamResult = new StreamResult(new File("./OrderResponse.xml"));
            transformer.transform(domSource, streamResult);
        }
    }
}


