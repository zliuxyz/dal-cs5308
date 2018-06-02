package dal.cs5308;

import org.w3c.dom.Document;

public interface IDOMGenerator {

    Document getInvalidXMLDOM();

    Document getUnAuthorizedDealerDOM();

    Document getInvalidAddressDOM();

    Document getInvalidItemListDOM();

    Document getInvalidItemEntryDOM();

    Document getValidOrderDOM(Document incomingDoc);
}
