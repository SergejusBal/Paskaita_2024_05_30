import org.example.Order;
import org.example.OrderManager;
import org.example.OrderManagerImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Test_getOrderById {


    OrderManager orderManager;

    @BeforeEach
    public void paruoštiObjektus() {

        orderManager = new OrderManagerImpl();

    }

    @Test
    public void getOrderById_CheckWithRealOrder_ReturnOrderBaseOnID() {

        //Arrange
        int orderID = 1;
        Order expectedOrder = new Order(orderID,"1",5.5,"new");
        orderManager.addOrder(expectedOrder);

        //Act
        Order actualOrder = orderManager.getOrderById(orderID);

        //Assert
        assertEquals(expectedOrder,actualOrder);
    }
    @Test
    public void getOrderById_CheckWithNonExistingOrderID_ReturnNull() {

        //Arrange
        int orderID = 1;

        //Act
        Order actualOrder = orderManager.getOrderById(orderID);

        //Assert
        assertNull(actualOrder);
    }




}
