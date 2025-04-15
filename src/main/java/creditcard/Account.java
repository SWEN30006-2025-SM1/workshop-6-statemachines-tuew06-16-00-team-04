package creditcard;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Account {
    private AccountState state;
    private DefaultState defaultState;
    private double balance;
    private double creditLimit;
    private LocalDateTime lastActivityDate;
    private boolean hasPaymentHistory;
    private double overdueAmount;

    public Account(double creditLimit) {
        this.state = AccountState.PENDING;
        this.creditLimit = creditLimit;
        this.balance = 0;
        this.lastActivityDate = LocalDateTime.now();
        this.hasPaymentHistory = false;
        this.overdueAmount = 0;
    }

    // State transition methods
    public void activateCard() {
        if (state == AccountState.PENDING) {
            state = AccountState.ACTIVE;
            lastActivityDate = LocalDateTime.now();
        }
    }

    public void reportLostOrStolen() {
        if (state == AccountState.ACTIVE) {
            state = AccountState.PENDING;
        }
    }

    public void makePayment(double amount) {
        if (state == AccountState.DEFAULT) {
            overdueAmount -= amount;
            if (overdueAmount <= 0) {
                state = AccountState.ACTIVE;
                defaultState = null;
            }
        } else {
            balance -= amount;
            if (state == AccountState.SUSPENDED && balance > 0) {
                state = AccountState.ACTIVE;
            }
        }
        lastActivityDate = LocalDateTime.now();
    }

    public void makePurchase(double amount) {
        if (state == AccountState.ACTIVE) {
            balance += amount;
            if (balance > creditLimit) {
                state = AccountState.SUSPENDED;
            }
            lastActivityDate = LocalDateTime.now();
        }
    }

    public void missPayment(double amount) {
        if (state == AccountState.ACTIVE) {
            state = AccountState.DEFAULT;
            overdueAmount = amount;
            defaultState = hasPaymentHistory ? DefaultState.PAYMENT_PLAN_OFFERED : DefaultState.GRACE_PERIOD;
        } else if (state == AccountState.DEFAULT && defaultState == DefaultState.HEALTHY_DEBT) {
            defaultState = DefaultState.UNHEALTHY_DEBT;
        }
    }

    public void acceptPaymentPlan() {
        if (state == AccountState.DEFAULT && defaultState == DefaultState.PAYMENT_PLAN_OFFERED) {
            defaultState = DefaultState.HEALTHY_DEBT;
        }
    }

    public void refusePaymentPlan() {
        if (state == AccountState.DEFAULT && defaultState == DefaultState.PAYMENT_PLAN_OFFERED) {
            defaultState = DefaultState.UNHEALTHY_DEBT;
        }
    }

    public void referToCollections() {
        if (state == AccountState.DEFAULT && defaultState == DefaultState.UNHEALTHY_DEBT) {
            defaultState = DefaultState.IN_COLLECTIONS;
            state = AccountState.CLOSED;
        }
    }

    public void checkInactivity() {
        if (state == AccountState.ACTIVE) {
            long monthsInactive = ChronoUnit.MONTHS.between(lastActivityDate, LocalDateTime.now());
            if (monthsInactive >= 6) {
                state = AccountState.INACTIVE;
            }
        } else if (state == AccountState.INACTIVE) {
            long monthsInactive = ChronoUnit.MONTHS.between(lastActivityDate, LocalDateTime.now());
            if (monthsInactive >= 6) {
                state = AccountState.CLOSED;
            }
        }
    }

    // Getters
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