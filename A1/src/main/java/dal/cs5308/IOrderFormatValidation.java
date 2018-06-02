package dal.cs5308;

import org.w3c.dom.Document;

public interface IOrderFormatValidation {
    enum OrderFormatResponse {
        INVALID_DELIVERY_ADDRESS,
        INVALID_ORDER_ITEM_LIST,
        INVALID_ORDER_ITEM_ENTRY,
        INVALID_TAG,
        VALID_ORDER_FORMAT
    }

    OrderFormatResponse isOrderFormatValid(Document incomingDoc);
}
