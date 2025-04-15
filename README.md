# Credit Card Management System State Machine

This project implements a state machine for a credit card management system as part of the SWEN30006 Software Modelling and Design workshop.

## Project Structure

The project consists of the following main components:

1. `AccountState.java` - Enum representing the main states of a credit card account
2. `DefaultState.java` - Enum representing the nested states within the DEFAULT state
3. `Account.java` - Main class implementing the state machine logic
4. `Main.java` - Demonstration class showing state transitions

## States

### Main States
- PENDING: Initial state when card is issued but not activated
- ACTIVE: Normal operating state
- SUSPENDED: When credit limit is exceeded
- DEFAULT: When payment is overdue
- INACTIVE: When card is not used for 6+ months
- CLOSED: Final state

### Default Sub-States
- GRACE_PERIOD: Initial default state with no history of missed payments
- PAYMENT_PLAN_OFFERED: After grace period or with history of missed payments
- HEALTHY_DEBT: Customer accepted payment plan
- UNHEALTHY_DEBT: Customer refused payment plan or missed payment
- IN_COLLECTIONS: Final state before account closure

## How to Run

1. Compile the project:
```bash
javac src/main/java/creditcard/*.java
```

2. Run the main class:
```bash
java -cp src/main/java creditcard.Main
```

## State Transitions

The implementation includes all required state transitions as specified in the workshop requirements, including:
- Card activation
- Lost/stolen card reporting
- Payment processing
- Purchase processing
- Default state management
- Inactivity handling
