public class BankAccount{
    private String name;
    private double checkingBalance;
    private double savingsBalance;
    private double totalAccountsBalance;
    private static int numberOfAccounts;
    private static double total;
    

    
    public BankAccount(){
        this.name = "Guest";
        this.checkingBalance = 0;
        numberOfAccounts++;

    }

    public double getTotalAccountsBalance(){
        this.totalAccountsBalance = getCheckingBalance() + getSavingsBalance();
        return totalAccountsBalance; 
    }

    public void deposit (String whichAccount ,double amount){
        if (whichAccount == "savings"){
            this.savingsBalance += amount;
            total += amount;

        }
        else if (whichAccount == "checking"){
            this.checkingBalance += amount;
            total += amount;
        }
        else {
            System.out.println("Please enter either savings or checking");
        }
    }

      public void withdrow (String whichAccount ,double amount){
        if ((whichAccount == "savings" && savingsBalance - amount <0) || 
        (whichAccount == "checking" && checkingBalance - amount <0)) {
            System.out.println("insufficient money");
        }
        
        else if (whichAccount == "savings"){
            this.savingsBalance -= amount;
            total -= amount;

        }
        else if (whichAccount == "checking"){
            this.checkingBalance -= amount;
            total -= amount;
        }
        else {
            System.out.println("Please enter either savings or checking");
        }
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public double getCheckingBalance() {
        return this.checkingBalance;
    }

    public void setCheckingBalance(double checkingBalance){
        this.checkingBalance = checkingBalance;
    }

    public double getSavingsBalance() {
        return this.savingsBalance;
    }

    public void setSavingsBalance(double savingsBalance){
        this.savingsBalance = savingsBalance;
    }

    public static int getNumberOfAccounts(){
        return numberOfAccounts;
    }
  
    public static double getTotal(){
        return total;
    }
   


}