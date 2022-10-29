import java.util.ArrayList;
public class TestOrders {
    public static void main(String[] args) {

        Order order1 = new Order();
        Order order2 = new Order();
        Order order3 = new Order("Jack");
        Order order4 = new Order("Sparrow");
        Order order5 = new Order("John");

        Item item1 = new Item("Cola", 3.5);
        Item item2 = new Item("Pepsi", 4.5);
        Item item3 = new Item("Juice", 2);
        Item item4 = new Item("Milk", 2.5);
        
        order1.addItem(item1);
        order1.addItem(item2);
        order2.addItem(item1);
        order2.addItem(item3);
        order3.addItem(item1);
        order3.addItem(item4);
        order4.addItem(item1);
        order4.addItem(item1);
        order5.addItem(item3);
        order5.addItem(item4);

        order1.display();
        System.out.println();
        order2.display();
        System.out.println();
        order3.display();
        System.out.println();
        order4.display();
        System.out.println();
        order5.display();
        

        order1.setReady(true);
        System.out.println(order1.getStatusMessage());
        System.out.println(order2.getStatusMessage());


        // System.out.println(order4.getName());
        // System.out.println(item4.getName());
        // System.out.println(order1.getItems().get(0).getName());

    }
}
