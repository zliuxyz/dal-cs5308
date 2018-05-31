package dal.cs5308;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.*;
import java.io.File;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Entity;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

/**
 * Created by Zongming Liu (B00784897)
 */
public class App {

    // Reference: https://docs.oracle.com/javase/tutorial/jaxp/dom/readingXML.html
    static final String outputEncoding = "UTF-8";

    private static void usage() {
        System.out.println("Usage: java -jar target/a1-1.0-SNAPSHOT.jar filename.xml");
    }

    public static void main(String[] args) throws Exception {
        // Reference: https://docs.oracle.com/javase/tutorial/jaxp/dom/readingXML.html
        String filename = null;

        if (args.length != 1) {
            usage();
        } else {
            filename = args[0];

        }
    }
}
