package creditcard;

public class Account {
    private AccountState state;
    private DefaultState defaultState;
    private double balance;
    private double creditLimit;
    private LocalDateTime lastActivityDate;
    private boolean hasPaymentHistory;
    private double overdueAmount;

    public Account(double creditLimit) {
    }

    public void activateCard() {
    }

    public void reportLostOrStolen() {
    }

    public void makePayment(double amount) {
    }

    public void makePurchase(double amount) {
    }

    public void missPayment(double amount) {
    }

    public void acceptPaymentPlan() {
    }

    public void refusePaymentPlan() {
    }

    public void referToCollections() {
    }

    public void checkInactivity() {
    }

    public AccountState getState() {
        return state;
    }

    public DefaultState getDefaultState() {
        return defaultState;
    }

    public double getBalance() {
        return balance;
    }

    public double getOverdueAmount() {
        return overdueAmount;
    }
} 