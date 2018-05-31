package dal.cs5308;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class PARTMANAGERTest {

    private IPARTMANAGER partManager;
    private DeliveryAddress deliveryAddress;

    @Before
    public void testSetup() {
        partManager = new MockPARTMANAGER();
        deliveryAddress = new DeliveryAddress();
    }

    @Test
    public void outOfStockTest() {
        assertEquals(IPARTMANAGER.PartResponse.OUT_OF_STOCK,
                partManager.submitPartForManufactureAndDelivery(1111, 10, deliveryAddress));
    }

    @Test
    public void noLongerManufacturedTest() {
        assertEquals(IPARTMANAGER.PartResponse.NO_LONGER_MANUFACTURED,
                partManager.submitPartForManufactureAndDelivery(2222, 10, deliveryAddress));
    }

    @Test
    public void successTest() {
        assertEquals(IPARTMANAGER.PartResponse.SUCCESS,
                partManager.submitPartForManufactureAndDelivery(1000, 10, deliveryAddress));
    }

    @After
    public void testTeardown() {
        partManager = null;
        deliveryAddress = null;
    }
}
