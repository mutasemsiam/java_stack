import java.util.ArrayList;

public class Order{
  private String name;
  private boolean ready;
  private ArrayList<Item> items = new ArrayList<Item>();

  public void addItem(Item newItem){
    this.items.add(newItem);

  }

  public String getStatusMessage(){
    if(this.ready){
      return "Your order is ready.";
    }
    else{
      return "Thank you for waiting. Your order will be ready soon.";
    }
  }

    public double getOrderTotal(){
        double sum = 0;
        for(Item i : this.items){
            sum += i.getPrice();
        }
        return sum;
    } 

    public void display(){
        System.out.println("Customer name: " + this.getName());
        for(Item i : this.items){
            System.out.println(i.getIndex() + " " + i.getName()  + "--$" +  i.getPrice());
        }
        System.out.println("Total:" + this.getOrderTotal());
    }


  public Order(){
    this.name = "Guest";
  }

  public Order(String name){
   this.name = name;
  }

  

   // getters
    public String getName() {
        return this.name;
    }
    public boolean isReady() {
        return this.ready;
    }
    
    public ArrayList<Item> getItems() {
        return this.items;
    }
    // setters
    public void setName(String orderName) {
        name = orderName;
    }
    public void setReady(boolean orderReady) {
        ready = orderReady;
    }
    public void setItems(ArrayList<Item> orderItems) {
        items = orderItems;
    }

}