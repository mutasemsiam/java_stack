public class Item{
    private String name;
    private double price; 


    public Item(String enteredName, double enteredPrice){
        this.name = enteredName;
        this.price = enteredPrice;
    }

    // getters
    public String getName() {
        return name;
    }
    
    public double getPrice() {
        return price;
    }
    // setters
    public void setName(String itemName) {
        name = itemName;
    }

    public void setPrice(String itemPrice) {
        name = itemPrice;
    }

}