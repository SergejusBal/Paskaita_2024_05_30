import org.example.Order;
import org.example.OrderManager;
import org.example.OrderManagerImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class Test_addOrder {

    static OrderManager orderManager;

    @BeforeAll
    public static void paruoštiObjektus() {

        orderManager = new OrderManagerImpl();

    }
    @Test
    public void addOrder_addOrderWithUniqueID_ReturnVoid() {

        //Arrange
        int orderID = 1;
        Order expectedOrder = new Order(orderID,"1",2.5,"New");

        //Act
        orderManager.addOrder(expectedOrder);
        Order actualOrder = orderManager.getOrderById(orderID);

        //Assert
        assertEquals(expectedOrder,actualOrder);
    }

    @Test
    public void addOrder_addOrderWithSameID_ReturnVoid() {

        //Arrange
        int OrderID = 2;
        Order expectedOrder2 = new Order(OrderID,"2",2.5,"New");
        Order expectedOrder3 = new Order(OrderID,"2",2.5,"New");

        //Act
        orderManager.addOrder(expectedOrder2);
        orderManager.addOrder(expectedOrder3);
        orderManager.removeOrder(OrderID);
        Order actualOrder = orderManager.getOrderById(OrderID);

        //Assert
        assertNull(actualOrder);
    }

}
