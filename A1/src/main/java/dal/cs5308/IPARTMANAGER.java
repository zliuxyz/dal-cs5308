package dal.cs5308;


public interface PARTMANAGER {

    enum PartResponse {
        SUCCESS,
        OUT_OF_STOCK,
        NO_LONGER_MANUFACTURED
    }

    // Submit part for manufacture and delivery.
    PartResponse submitPartForManufactureAndDelivery(int partNumber, int quantity, DeliveryAddress deliveryAddress);
}
