package dal.cs5308;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import dal.cs5308.IOrderFormatValidation.OrderFormatResponse;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class OrderFormatValidationTest {

    private IOrderFormatValidation iOrderFormatValidation;
    private DocumentBuilder db;

    @Before
    public void testSetup() throws ParserConfigurationException {
        iOrderFormatValidation = new OrderFormatValidation();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setIgnoringComments(true);
        db = dbf.newDocumentBuilder();
    }

    @Test
    public void validOrder() throws IOException, SAXException {
        Document incomingDoc = db.parse(new File("test-files/ValidOrder.xml"));
        OrderFormatResponse response = iOrderFormatValidation.isOrderFormatValid(incomingDoc);
        assertTrue(response == OrderFormatResponse.VALID_ORDER_FORMAT);
    }

    @Test
    public void InvalidDeliveryAddressCity() throws IOException, SAXException {
        Document incomingDoc = db.parse(new File("test-files/InvalidDeliveryAddress-City.xml"));
        OrderFormatResponse response = iOrderFormatValidation.isOrderFormatValid(incomingDoc);
        assertTrue(response == OrderFormatResponse.INVALID_DELIVERY_ADDRESS);
    }

    @Test
    public void InvalidDeliveryAddressMissingTags() throws IOException, SAXException {
        Document incomingDoc = db.parse(new File("test-files/InvalidDeliveryAddress-MissingTags.xml"));
        OrderFormatResponse response = iOrderFormatValidation.isOrderFormatValid(incomingDoc);
        assertTrue(response == OrderFormatResponse.INVALID_DELIVERY_ADDRESS);
    }

    @Test
    public void InvalidDeliveryAddressPostCode() throws IOException, SAXException {
        Document incomingDoc = db.parse(new File("test-files/InvalidDeliveryAddress-PostCode.xml"));
        OrderFormatResponse response = iOrderFormatValidation.isOrderFormatValid(incomingDoc);
        assertTrue(response == OrderFormatResponse.INVALID_DELIVERY_ADDRESS);
    }

    @Test
    public void InvalidDeliveryAddressProvince() throws IOException, SAXException {
        Document incomingDoc = db.parse(new File("test-files/InvalidDeliveryAddress-Province.xml"));
        OrderFormatResponse response = iOrderFormatValidation.isOrderFormatValid(incomingDoc);
        assertTrue(response == OrderFormatResponse.INVALID_DELIVERY_ADDRESS);
    }

    @Test
    public void InvalidDeliveryAddressStreet() throws IOException, SAXException {
        Document incomingDoc = db.parse(new File("test-files/InvalidDeliveryAddress-Street.xml"));
        OrderFormatResponse response = iOrderFormatValidation.isOrderFormatValid(incomingDoc);
        assertTrue(response == OrderFormatResponse.INVALID_DELIVERY_ADDRESS);
    }

    @Test
    public void InvalidOrderItemEntryPartNumber() throws IOException, SAXException {
        Document incomingDoc = db.parse(new File("test-files/InvalidOrderItemEntry-PartNumber.xml"));
        OrderFormatResponse response = iOrderFormatValidation.isOrderFormatValid(incomingDoc);
        assertTrue(response == OrderFormatResponse.INVALID_ORDER_ITEM_ENTRY);
    }

    @Test
    public void InvalidOrderItemEntryQuantity() throws IOException, SAXException {
        Document incomingDoc = db.parse(new File("test-files/InvalidOrderItemEntry-Quantity.xml"));
        OrderFormatResponse response = iOrderFormatValidation.isOrderFormatValid(incomingDoc);
        assertTrue(response == OrderFormatResponse.INVALID_ORDER_ITEM_ENTRY);
    }

    @Test
    public void InvalidOrderItemList() throws IOException, SAXException {
        Document incomingDoc = db.parse(new File("test-files/InvalidOrderItemList.xml"));
        OrderFormatResponse response = iOrderFormatValidation.isOrderFormatValid(incomingDoc);
        assertTrue(response == OrderFormatResponse.INVALID_ORDER_ITEM_LIST);
    }

    @Test
    public void InvalidTag() throws IOException, SAXException {
        Document incomingDoc = db.parse(new File("test-files/InvalidTag.xml"));
        OrderFormatResponse response = iOrderFormatValidation.isOrderFormatValid(incomingDoc);
        assertTrue(response == OrderFormatResponse.INVALID_TAG);
    }


    @After
    public void testTearDown() {
        iOrderFormatValidation = null;
    }




}
