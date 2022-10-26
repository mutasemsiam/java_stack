import java.util.ArrayList;
public class TestOrders {
    public static void main(String[] args) {
    
        // Menu items
    
        // Order variables -- order1, order2 etc.
    
        // Application Simulations
        // Use this example code to test various orders' updates
           // Create a new order, and assign it some values
        Item item1 = new Item();
        item1.name = "cola";
        item1.price = 2.5;
        Item item2 = new Item("Pepsi", 3.5);
        Item item3 = new Item("XL", 5.5);
        Item item4 = new Item("Cappy", 4.5);


        Order order1 = new Order();
        order1.name = "Cinhuri";
        // order1.total = item1.price + item2.price + item3.price;
        order1.ready = true;
        order1.items.add(item1);
        order1.items.add(item2);
        order1.items.add(item3);
        order1.items.add(item4);
        ArrayList<Item> myTotal = order1.items;
        double sum = 0;
        for (int i = 0; i < myTotal.size(); i++){
            sum += myTotal.get(i).price;
        }
        order1.total = sum;

        Order order2 = new Order();
        order2.name = "Jimmy";
        // order2.total = item1.price;
        order2.ready = false;
        order2.items.add(item1);
        order2.items.add(item2);
        ArrayList<Item> myTotal2 = order2.items;
        double sum2 = 0;
        for (int i = 0; i < myTotal2.size(); i++){
            sum2 += myTotal2.get(i).price;
        }
        order2.total = sum2;
    

        Order order3 = new Order();
        order3.name = "Noah";
        order3.total = item4.price;
        order3.ready = true;
        order3.items.add(item4);

        Order order4 = new Order();
        order4.name = "Sam";
        order4.total = item3.price;
        order4.ready = true;
        order4.items.add(item3);

        System.out.println("**********************************");
        //****************************** printing first order
        System.out.printf("Name: %s\n", order1.name);
        System.out.printf("Total: %s\n", order1.total);
        System.out.printf("Ready: %s\n", order1.ready);

        // System.out.printf("Items: %s %s %s\n", item1, item2.name, item3.name);

        // ArrayList<Item> myArray = new ArrayList<Item>();
        ArrayList<Item> myArray = order1.items;
        System.out.printf("Items: \n");
        for (int i = 0; i < myArray.size(); i++){
		System.out.printf("%s\n", myArray.get(i).name);

		}
        System.out.println("**********************************");
        //****************************** printing second order

        System.out.printf("Name: %s\n", order2.name);
        System.out.printf("Total: %s\n", order2.total);
        System.out.printf("Ready: %s\n", order2.ready);
        ArrayList<Item> myArray2 = order2.items;
        System.out.printf("Items: \n");
        for (int i = 0; i < myArray2.size(); i++){
		System.out.printf("%s\n", myArray2.get(i).name);

		}

        System.out.println("**********************************");
        //****************************** printing fourth order

        System.out.printf("Name: %s\n", order4.name);
        System.out.printf("Total: %s\n", order4.total);
        System.out.printf("Ready: %s\n", order4.ready);
        ArrayList<Item> myArray4 = order4.items;
        System.out.printf("Items: \n");
        for (int i = 0; i < myArray4.size(); i++){
		System.out.printf("%s\n", myArray4.get(i).name);

		}
        // System.out.println(order4.items.get(0).name);

    }
}
