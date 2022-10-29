import java.util.ArrayList;

public class CoffeeKiosk{

    private ArrayList<Item> menu;
    private ArrayList<Order> orders;

    public CoffeeKiosk(){
        this.menu = new ArrayList<Item>();
        this.orders = new ArrayList<Order>();

    }

    public ArrayList<Item> getMenu(){
        return this.menu;
    }
    public ArrayList<Order> getOrders(){
        return this.orders;
    }

    //methods

     public void addMenuItem(String name, double price){
        Item newItem = new Item(name, price);
        menu.add(newItem);
        int index = menu.indexOf(newItem);
        newItem.setIndex(index);
    }

    public void displayMenu(){
        for(Item i: this.menu){
            System.out.println(i.getIndex() + " "+ i.getName() + " -- $" + i.getPrice());
        }
    }
        public void newOrder() {
        
    	// Shows the user a message prompt and then sets their input to a variable, name
        System.out.println("Please enter customer name for new order:");
        String name = System.console().readLine();
    
    	// Your code:
        // Create a new order with the given input string
        Order nnewOrder = new Order(name);
        // Show the user the menu, so they can choose items to add.
        displayMenu();
        
    	// Prompts the user to enter an item number
        System.out.println("Please enter a menu item index or q to quit:");
        String itemNumber = System.console().readLine();
        
        // Write a while loop to collect all user's order items
        while(!itemNumber.equals("q")) {
            
            // Get the item object from the menu, and add the item to the order
            int i = Integer.parseInt(itemNumber);
            if(i < this.menu.size()){
                Item orderItem = menu.get(i);
                nnewOrder.addItem(orderItem);
            } else {
                System.out.println("Please enter a number from the menu");
            }
            // Ask them to enter a new item index or q again, and take their input
            System.out.println("Please add another item if you would like, or enter q to exit");
            itemNumber = System.console().readLine();
        }
        // After you have collected their order, print the order details 
    	// as the example below. You may use the order's display method.
        nnewOrder.display();
        
    }

}