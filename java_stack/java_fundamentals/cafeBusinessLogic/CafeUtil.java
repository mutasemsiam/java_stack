import java.util.ArrayList;
public class CafeUtil{
    public int getStreakGoal(){

        int sum = 0;
        for(int i = 1; i<=10; i++){
            sum+=1;
        }
        return sum;
        
    }

    public double getOrderTotal(double[] prices){

        double sumPrices = 0;
        for(double price:prices){
            sumPrices+=price;
        }
        return sumPrices;
    }

    public void displayMenu(ArrayList<String> menuItems){

        for(int i=0; i<menuItems.size();i++){
            System.out.printf("%s %s\n", i, menuItems.get(i));
        }
    }

    public void addCustomer(ArrayList<String> customerList){
        System.out.println("Please enter your name:");
        String userName = System.console().readLine();
        System.out.printf("Hello, %s\n", userName);
        System.out.printf("There are %d people in front of you\n", customerList.size());
        customerList.add(userName); 
        System.out.println(customerList);
        
    }







}