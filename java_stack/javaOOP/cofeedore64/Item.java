public class Item{
    private String name;
    private double price; 
    private int index;


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

    public int getIndex(){
        return this.index;
    }
    // setters
    public void setName(String itemName) {
        name = itemName;
    }

    public void setPrice(String itemPrice) {
        name = itemPrice;
    }

    public void setIndex(int index){
        this.index = index;
    }


}