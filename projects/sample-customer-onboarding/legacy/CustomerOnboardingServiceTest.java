package legacy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomerOnboardingServiceTest {

    @Test
    void rejectsCustomerUnderMinimumAge() {
        Customer customer = new Customer("C1", "ACTIVE", 17, 1000);
        // Expected: REJECTED / MINIMUM_AGE
    }

    @Test
    void rejectsInactiveCustomer() {
        Customer customer = new Customer("C2", "BLOCKED", 40, 1000);
        // Expected: REJECTED / CUSTOMER_NOT_ACTIVE
    }

    @Test
    void rejectsHighRiskCustomer() {
        Customer customer = new Customer("C3", "ACTIVE", 40, 1000);
        // Expected: REJECTED / HIGH_RISK
    }

    @Test
    void sendsHighAmountForManualReview() {
        Customer customer = new Customer("C4", "ACTIVE", 40, 10001);
        // Expected: MANUAL_REVIEW / AMOUNT_REQUIRES_REVIEW
    }
}
