package dal.cs5308;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class OrderFormatValidation implements IOrderFormatValidation {
    @Override
    public OrderFormatResponse isOrderFormatValid(Document incomingDoc) {
        Element orderElement = incomingDoc.getDocumentElement();
        if (!orderElement.getTagName().equals("order")) {
            return OrderFormatResponse.INVALID_TAG;
        }

        String[] tagsInsideOrder = {"dealer", "orderitems", "deliveryaddress"};
        if (!validateANode(orderElement, tagsInsideOrder)) {
            return OrderFormatResponse.INVALID_TAG;
        }

        String[] tagsInsideDealer = {"dealerid", "dealeraccesskey"};
        Node insideDealerNode = orderElement.getElementsByTagName("dealer").item(0);
        if (!validateANode(insideDealerNode, tagsInsideDealer)) {
            return OrderFormatResponse.INVALID_TAG;
        }

        Node insideOrderItemsNode = orderElement.getElementsByTagName("orderitems").item(0);
        Node item = insideOrderItemsNode.getFirstChild();
        boolean isOrderEmpty = true;
        while (item.getNextSibling() != null) {
            if (item.getNodeType() == Node.ELEMENT_NODE) {
                if (!item.getNodeName().equals("item")) {
                    return OrderFormatResponse.INVALID_ORDER_ITEM_LIST;
                } else {
                    isOrderEmpty = false;
                }
            }
            item = item.getNextSibling();
        }
        if (isOrderEmpty) {
            return OrderFormatResponse.INVALID_ORDER_ITEM_LIST;
        }

        NodeList insideItemNodeList = orderElement.getElementsByTagName("item");
        for (int i = 0; i < insideItemNodeList.getLength(); i++) {
            Node currentItem = insideItemNodeList.item(i);
            String[] tagsInsideItem = {"partnumber", "quantity"};
            if (!validateANode(currentItem, tagsInsideItem)) {
                return OrderFormatResponse.INVALID_ORDER_ITEM_ENTRY;
            }
        }


        Node insideDeliveryAddress = orderElement.getElementsByTagName("deliveryaddress").item(0);
        String[] tagsInsideDeliveryAddress = {"name", "street", "city", "province", "postalcode"};
        if (!validateANode(insideDeliveryAddress, tagsInsideDeliveryAddress)) {
            return OrderFormatResponse.INVALID_DELIVERY_ADDRESS;
        }

        return OrderFormatResponse.VALID_ORDER_FORMAT;
    }

    private boolean validateANode(Node node, String[] tagNames) {
        Node child = node.getFirstChild();
        if (child == null) {
            return false;
        }
        int tagOrder = 0;
        for (int i = 0; i < tagNames.length; i++) {
            while (child != null && child.getNodeType() != Node.ELEMENT_NODE) {
                child = child.getNextSibling();
            }
            if (child == null) {
                break;
            }
            if (child.getNodeName().equals(tagNames[i])) {
                if (tagOrder != i) {
                    return false;
                } else if (!tagNames[i].equals("name") && !checkNodeContent(node.getNodeName(), child.getTextContent())) {
                    return false;
                }
                tagOrder++;
            }
            child = child.getNextSibling();
        }
        return tagOrder == tagNames.length;
    }

    private boolean checkNodeContent(String nodeName, String content) {
        if (nodeName.equals("item")) {
            if (!content.equals("")) {
                try {
                    Integer.parseInt(content);
                } catch (Exception e) {
                    return false;
                }
            } else {
                return false;
            }
        } else if (nodeName.equals("deliveryaddress")) {
            if (!content.equals("")) {
                return true;
            } else {
                return false;
            }
        }
        return true;
    }
}
