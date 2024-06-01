import org.example.Order;
import org.example.OrderManager;
import org.example.OrderManagerImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Test_updateOrderStatus {

    static OrderManager orderManager;

    @BeforeAll
    public static void paruoštiObjektus() {
        orderManager = new OrderManagerImpl();
    }

    @Test
    public void updateOrderStatus_CheckWithExistingOrderID_ReturnTrue() {

        //Arrange
        int orderID = 1;
        Order order = new Order(orderID, "1", 5.5, "New");
        orderManager.addOrder(order);


        //Act
        boolean actualBoolean = orderManager.updateOrderStatus(orderID,"Done");

        //Assert
        assertTrue(actualBoolean);
    }
    @Test
    public void updateOrderStatus_CheckWithNonExistingOrderID_ReturnFalse() {

        //Arrange
        int orderID = 2;

        //Act
        boolean actualBoolean = orderManager.updateOrderStatus(orderID,"Done");

        //Assert
        assertFalse(actualBoolean);
    }

    @Test
    public void updateOrderStatus_CheckIfCorrectlyUpdated_ReturnTrue() {

        //Arrange
        int orderID = 3;
        Order order = new Order(orderID, "1", 5.5, "New");
        orderManager.addOrder(order);
        String expectedString = "Done";

        //Act
        orderManager.updateOrderStatus(orderID,"Done");
        String actualString = orderManager.getOrderById(orderID).getStatus();

        //Assert
        assertEquals(expectedString,actualString);
    }






}
