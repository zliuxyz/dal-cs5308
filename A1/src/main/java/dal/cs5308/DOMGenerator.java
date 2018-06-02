package dal.cs5308;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class DOMGenerator implements IDOMGenerator {

    private static DocumentBuilder documentBuilder;

    DOMGenerator() throws ParserConfigurationException {
        documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
    }

    @Override
    public Document getInvalidXMLDOM() {
        Document document = documentBuilder.newDocument();
        Element root = document.createElement("order");
        document.appendChild(root);

        Element result = document.createElement("result");
        result.appendChild(document.createTextNode("failure"));
        root.appendChild(result);

        Element error = document.createElement("error");
        error.appendChild(document.createTextNode("Invalid XML"));
        root.appendChild(error);

        return document;
    }

    @Override
    public Document getUnAuthorizedDealerDOM() {
        Document document = documentBuilder.newDocument();
        Element root = document.createElement("order");
        document.appendChild(root);

        Element result = document.createElement("result");
        result.appendChild(document.createTextNode("failure"));
        root.appendChild(result);

        Element error = document.createElement("error");
        error.appendChild(document.createTextNode("Not authorized"));
        root.appendChild(error);

        return document;
    }

    @Override
    public Document getInvalidAddressDOM() {
        Document document = documentBuilder.newDocument();
        Element root = document.createElement("order");
        document.appendChild(root);

        Element result = document.createElement("result");
        result.appendChild(document.createTextNode("failure"));
        root.appendChild(result);

        Element error = document.createElement("error");
        error.appendChild(document.createTextNode("Invalid order"));
        root.appendChild(error);

        Element errorMessage = document.createElement("errormessage");
        errorMessage.appendChild(document.createTextNode("Invalid delivery address"));
        root.appendChild(errorMessage);

        return document;
    }

    @Override
    public Document getInvalidItemListDOM() {
        Document document = documentBuilder.newDocument();
        Element root = document.createElement("order");
        document.appendChild(root);

        Element result = document.createElement("result");
        result.appendChild(document.createTextNode("failure"));
        root.appendChild(result);

        Element error = document.createElement("error");
        error.appendChild(document.createTextNode("Invalid order"));
        root.appendChild(error);

        Element errorMessage = document.createElement("errormessage");
        errorMessage.appendChild(document.createTextNode("Invalid order item list"));
        root.appendChild(errorMessage);

        return document;
    }

    @Override
    public Document getInvalidItemEntryDOM() {
        Document document = documentBuilder.newDocument();
        Element root = document.createElement("order");
        document.appendChild(root);

        Element result = document.createElement("result");
        result.appendChild(document.createTextNode("failure"));
        root.appendChild(result);

        Element error = document.createElement("error");
        error.appendChild(document.createTextNode("Invalid order"));
        root.appendChild(error);

        Element errorMessage = document.createElement("errormessage");
        errorMessage.appendChild(document.createTextNode("Invalid order item entry"));
        root.appendChild(errorMessage);

        return document;
    }

    @Override
    public Document getValidOrderDOM(Document incomingDoc) {
        Document document = documentBuilder.newDocument();
        Element root = document.createElement("order");
        document.appendChild(root);

        Element orderItems = document.createElement("orderitems");

        IDatabase iDatabase = new MockDatabase();
        IPARTMANAGER ipartmanager = new MockPARTMANAGER();

        DeliveryAddress deliveryAddress = new DeliveryAddress();
        deliveryAddress.name = incomingDoc.getElementsByTagName("name").item(0).getTextContent();
        deliveryAddress.street = incomingDoc.getElementsByTagName("street").item(0).getTextContent();
        deliveryAddress.city = incomingDoc.getElementsByTagName("city").item(0).getTextContent();
        deliveryAddress.province = incomingDoc.getElementsByTagName("province").item(0).getTextContent();
        deliveryAddress.postalCode = incomingDoc.getElementsByTagName("postalcode").item(0).getTextContent();

        NodeList parts = incomingDoc.getElementsByTagName("partnumber");
        NodeList quantities = incomingDoc.getElementsByTagName("quantity");
        int numberOfItems = parts.getLength();

        for (int i = 0; i < numberOfItems; i++) {

            Element itemElement = document.createElement("item");

            Element partNumberElement = document.createElement("partnumber");
            int partNumber = Integer.parseInt(parts.item(i).getTextContent());
            partNumberElement.appendChild(document.createTextNode(parts.item(i).getTextContent()));

            itemElement.appendChild(partNumberElement);

            Element quantityElement = document.createElement("quantity");
            int quantity = Integer.parseInt(quantities.item(i).getTextContent());
            quantityElement.appendChild(document.createTextNode(quantities.item(i).getTextContent()));

            itemElement.appendChild(quantityElement);

            Element resultElement = document.createElement("result");

            Element errorMessageElement = document.createElement("errormessage");

            if (iDatabase.isPartNumberValid(partNumber)) {
                IPARTMANAGER.PartResponse partResponse = ipartmanager.submitPartForManufactureAndDelivery(partNumber, quantity, deliveryAddress);
                if (partResponse == IPARTMANAGER.PartResponse.SUCCESS) {
                    resultElement.appendChild(document.createTextNode("success"));
                    errorMessageElement.appendChild(document.createTextNode(""));
                } else if (partResponse == IPARTMANAGER.PartResponse.OUT_OF_STOCK) {
                    resultElement.appendChild(document.createTextNode("failure"));
                    errorMessageElement.appendChild(document.createTextNode("out of stock"));
                } else {
                    resultElement.appendChild(document.createTextNode("failure"));
                    errorMessageElement.appendChild(document.createTextNode("no longer manufactured"));
                }

            } else {
                resultElement.appendChild(document.createTextNode("failure"));
                errorMessageElement.appendChild(document.createTextNode("invalid part"));
            }

            itemElement.appendChild(resultElement);
            itemElement.appendChild(errorMessageElement);

            orderItems.appendChild(itemElement);
        }
        root.appendChild(orderItems);

        return document;
    }

}
