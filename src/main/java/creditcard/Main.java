package creditcard;

public class Main {
    public static void main(String[] args) {
        Account account = new Account(1000.0);
        System.out.println("Initial state: " + account.getState());

        account.activateCard();
        System.out.println("After activation: " + account.getState());

        account.makePurchase(500.0);
        System.out.println("After purchase: " + account.getState() + ", Balance: " + account.getBalance());

        account.missPayment(200.0);
        System.out.println("After missed payment: " + account.getState());
        System.out.println("Default state: " + account.getDefaultState());
        System.out.println("Overdue amount: " + account.getOverdueAmount());

        account.acceptPaymentPlan();
        System.out.println("After accepting payment plan: " + account.getDefaultState());

        account.makePayment(200.0);
        System.out.println("After payment: " + account.getState());

        account.reportLostOrStolen();
        System.out.println("After reporting lost: " + account.getState());

        account.activateCard();
        System.out.println("After reactivation: " + account.getState());

        account.makePurchase(1500.0);
        System.out.println("After exceeding limit: " + account.getState());

        account.makePayment(1000.0);
        System.out.println("After payment: " + account.getState());
    }
} 