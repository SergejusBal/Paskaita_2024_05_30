import org.example.Order;
import org.example.OrderManager;
import org.example.OrderManagerImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class Test_getOrdersAboveCertainValue {

    static OrderManager orderManager;

    @BeforeAll
    public static void paruoštiObjektus() {

        orderManager = new OrderManagerImpl();
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

    }

    @Test
    public void getOrdersAboveCertainValue_CheckWithAverageValue_ReturnList() {

        //Arrange
        double certainValue = 2.5;
        int expectedListSize = 2;

        //Act
        int actualListSize = orderManager.getOrdersAboveCertainValue(certainValue).size();

        //Assert
        assertEquals(expectedListSize,actualListSize);
    }

    @Test
    public void getOrdersAboveCertainValue_CheckWithHigherValue_ReturnEmptyList() {

        //Arrange
        double certainValue = 20;
        int expectedListSize = 0;

        //Act
        int actualListSize = orderManager.getOrdersAboveCertainValue(certainValue).size();

        //Assert
        assertEquals(expectedListSize,actualListSize);
    }

    @Test
    public void getOrdersAboveCertainValue_CheckWithZeroValue_ReturnList() {

        //Arrange
        double certainValue = 0;
        int expectedListSize = 5;

        //Act
        int actualListSize = orderManager.getOrdersAboveCertainValue(certainValue).size();

        //Assert
        assertEquals(expectedListSize,actualListSize);
    }



}
