package creditcard;

public class Main {
    public static void main(String[] args) {
        // Create a new account with $1000 credit limit
        Account account = new Account(1000.0);
        System.out.println("Initial state: " + account.getState());

        // Activate the card
        account.activateCard();
        System.out.println("After activation: " + account.getState());

        // Make some purchases
        account.makePurchase(500.0);
        System.out.println("After purchase: " + account.getState() + ", Balance: " + account.getBalance());

        // Miss a payment
        account.missPayment(200.0);
        System.out.println("After missed payment: " + account.getState());
        System.out.println("Default state: " + account.getDefaultState());
        System.out.println("Overdue amount: " + account.getOverdueAmount());

        // Accept payment plan
        account.acceptPaymentPlan();
        System.out.println("After accepting payment plan: " + account.getDefaultState());

        // Make payment
        account.makePayment(200.0);
        System.out.println("After payment: " + account.getState());

        // Report card lost
        account.reportLostOrStolen();
        System.out.println("After reporting lost: " + account.getState());

        // Reactivate card
        account.activateCard();
        System.out.println("After reactivation: " + account.getState());

        // Make purchase exceeding credit limit
        account.makePurchase(1500.0);
        System.out.println("After exceeding limit: " + account.getState());

        // Make payment to reactivate
        account.makePayment(1000.0);
        System.out.println("After payment: " + account.getState());
    }
} 