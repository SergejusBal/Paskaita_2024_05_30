import org.example.Order;
import org.example.OrderManager;
import org.example.OrderManagerImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test_calculateTotalRevenue {
    static OrderManager orderManager;

    @BeforeAll
    public static void paruoštiObjektus() {

        orderManager = new OrderManagerImpl();

    }

    @Test
    public void calculateTotalRevenue_CheckWithNoOrders_ReturnZero() {

        //Arrange
        double expectedAmount = 0;

        //Act
        double actualValue = orderManager.calculateTotalRevenue();

        //Assert
        assertEquals(expectedAmount,actualValue);
    }

    @Test
    public void calculateTotalRevenue_CheckWithFiveOrders_ReturnOrderAmountSum() {

        //Arrange
        Order Order1 = new Order(1,"1",5.5,"New");
        Order Order2 = new Order(2,"1",1.5,"New");
        Order Order3 = new Order(3,"1",7.5,"New");
        Order Order4 = new Order(4,"1",2.5,"New");
        Order Order5 = new Order(5,"1",1.5,"New");
        orderManager.addOrder(Order1);
        orderManager.addOrder(Order2);
        orderManager.addOrder(Order3);
        orderManager.addOrder(Order4);
        orderManager.addOrder(Order5);

        double expectedAmount = 18.5;
        //Act
        double actualValue = orderManager.calculateTotalRevenue();
        //Assert
        assertEquals(expectedAmount,actualValue);
    }




}
