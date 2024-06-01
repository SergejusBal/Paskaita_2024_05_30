import org.example.Order;
import org.example.OrderManager;
import org.example.OrderManagerImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test_filterOrdersByStatus {
    OrderManager orderManager;

    @BeforeEach
    public void paruoštiObjektus() {

        orderManager = new OrderManagerImpl();

    }

    @Test
    public void filterOrderByStatus_CheckWithNoOrders_ReturnEmptyList() {

        //Arrange
        String OrderStatus = "new";
        int expectedListSize = 0;

        //Act
        int actualListSize = orderManager.filterOrdersByStatus(OrderStatus).size();

        //Assert
        assertEquals(expectedListSize,actualListSize);
    }

    @Test
    public void filterOrderByStatus_CheckWithManySameOrders_ReturnOrderList() {

        //Arrange
        String OrderStatus = "new";
        Order Order1 = new Order(1,"1",5.5,OrderStatus);
        Order Order2 = new Order(2,"1",1.5,OrderStatus);
        orderManager.addOrder(Order1);
        orderManager.addOrder(Order2);

        int expectedListSize = 2;

        //Act
        int actualListSize = orderManager.filterOrdersByStatus(OrderStatus).size();

        //Assert
        assertEquals(expectedListSize,actualListSize);
    }

    @Test
    public void filterOrderByStatus_CheckWithManyDifferentOrders_ReturnOrderList() {
        //Arrange
        String OrderStatus = "new";
        String OrderStatus2 = "paid";

        Order Order1 = new Order(1,"1",5.5,OrderStatus);
        Order Order2 = new Order(2,"1",1.5,OrderStatus);
        Order Order3 = new Order(3,"1",1.5,OrderStatus2);

        orderManager.addOrder(Order1);
        orderManager.addOrder(Order2);
        orderManager.addOrder(Order3);

        int expectedListSize = 2;

        //Act
        int actualListSize = orderManager.filterOrdersByStatus(OrderStatus).size();

        //Assert
        assertEquals(expectedListSize,actualListSize);

    }


}
