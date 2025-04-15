package creditcard;

public enum AccountState {
    PENDING,        // Initial state when card is issued but not activated
    ACTIVE,         // Normal operating state
    SUSPENDED,      // When credit limit is exceeded
    DEFAULT,        // When payment is overdue
    INACTIVE,       // When card is not used for 6+ months
    CLOSED          // Final state
} 