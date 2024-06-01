import org.example.Order;
import org.example.OrderManager;
import org.example.OrderManagerImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test_getOrdersByCustomer {

    OrderManager orderManager;

    @BeforeEach
    public void paruoštiObjektus() {

        orderManager = new OrderManagerImpl();

    }

    @Test
    public void getOrderByCustomer_checkWithRealCustomerID_ReturnList() {

        //Arrange
        Order Order1 = new Order(1,"1",5.5,"New");
        Order Order2 = new Order(2,"2",1.5,"New");
        Order Order3 = new Order(3,"3",7.5,"New");
        Order Order4 = new Order(4,"1",2.5,"New");
        Order Order5 = new Order(5,"1",1.5,"New");
        orderManager.addOrder(Order1);
        orderManager.addOrder(Order2);
        orderManager.addOrder(Order3);
        orderManager.addOrder(Order4);
        orderManager.addOrder(Order5);

        String customerID = "1";

        int expectedListSize = 3;

        //Act
        int actualListSize = orderManager.getOrdersByCustomer(customerID).size();
        //Assert
        assertEquals(expectedListSize,actualListSize);
    }

    @Test
    public void getOrderByCustomer_checkWithNonExistingCustomerID_ReturnEmptyList() {

        //Arrange
        String customerID = "1";
        int expectedListSize = 0;

        //Act
        int actualListSize = orderManager.getOrdersByCustomer(customerID).size();
        //Assert
        assertEquals(expectedListSize,actualListSize);
    }
    @Test
    public void getOrderByCustomer_checkWithNullValue_ReturnEmptyList() {

        //Arrange
        String customerID = null;
        int expectedListSize = 0;

        //Act
        int actualListSize = orderManager.getOrdersByCustomer(customerID).size();
        //Assert
        assertEquals(expectedListSize,actualListSize);
    }






}
