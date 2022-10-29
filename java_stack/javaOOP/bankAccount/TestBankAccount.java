public class TestBankAccount{

    public static void main(String[] args) {

        BankAccount account1 = new BankAccount();
        System.out.println(account1.getName());
        account1.deposit("savings", 5000);
        account1.deposit("checking", 3500);
        System.out.println(account1.getSavingsBalance());
        System.out.println(account1.getTotal());
        System.out.println();
        // account1.withdrow("checking", 2000);
        // System.out.println(account1.getTotal());
        System.out.println(account1.getTotalAccountsBalance());





    }

}