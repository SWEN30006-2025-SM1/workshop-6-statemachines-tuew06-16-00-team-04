package creditcard;

public enum DefaultState {
    GRACE_PERIOD,       // Initial default state with no history of missed payments
    PAYMENT_PLAN_OFFERED, // After grace period or with history of missed payments
    HEALTHY_DEBT,       // Customer accepted payment plan
    UNHEALTHY_DEBT,     // Customer refused payment plan or missed payment
    IN_COLLECTIONS      // Final state before account closure
} 