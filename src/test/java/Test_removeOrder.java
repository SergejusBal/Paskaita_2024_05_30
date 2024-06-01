import org.example.Order;
import org.example.OrderManager;
import org.example.OrderManagerImpl;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Test_removeOrder {
    static OrderManager orderManager;
    static Order controlCheckOrder;

    @BeforeAll
    public static void paruoštiObjektus() {
        orderManager = new OrderManagerImpl();
        controlCheckOrder = new Order(99,"99",99,"paid");
        orderManager.addOrder(controlCheckOrder);
    }

    @Test
    public void removeOrder_CheckWithExistingOrderID_ReturnVoid() {

        //Arrange
        int orderID = 1;
        Order order = new Order(orderID, "1", 5.5, "New");
        orderManager.addOrder(order);


        //Act
        orderManager.removeOrder(orderID);
        Order actualOrder = orderManager.getOrderById(orderID);

        //Assert
        assertNull(actualOrder);
    }

    @Test
    public void removeOrder_CheckWithNonExistingOrderID_ReturnVoid() {

        //Arrange
        int orderID = 2;

        //Act
        orderManager.removeOrder(orderID);
        Order actualOrder = orderManager.getOrderById(orderID);

        //Assert
        assertNull(actualOrder);
    }

    @AfterAll
    public static void removeOrder_CheckIfOtherOrderGotDeleted_ReturnVoid() {

        //Arrange
        int orderID = 99;
        Order expectedOrder = controlCheckOrder;

        //Act
        Order actualOrder = orderManager.getOrderById(orderID);

        //Assert
        assertEquals(expectedOrder,actualOrder);
    }




}
