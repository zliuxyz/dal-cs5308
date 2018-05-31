package dal.cs5308;

public class MockPARTMANAGER implements IPARTMANAGER {

    /*
    Returns OUT_OF_STOCK if partNumber is 1111, returns NO_LONGER_MANUFACTURED if partNumber is 2222,
    returns SUCCESS otherwise.
     */
    @Override
    public PartResponse submitPartForManufactureAndDelivery(int partNumber, int quantity, DeliveryAddress deliveryAddress) {
        if (partNumber == 1111) {
            return PartResponse.OUT_OF_STOCK;
        } else if (partNumber == 2222) {
            return PartResponse.NO_LONGER_MANUFACTURED;
        } else {
            return PartResponse.SUCCESS;
        }
    }
}
