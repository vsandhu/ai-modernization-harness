package legacy;

public class CustomerOnboardingService {

    private static final int MINIMUM_AGE = 18;
    private static final int HIGH_RISK_SCORE = 80;
    private static final double MANUAL_REVIEW_AMOUNT = 10000.0;

    private final CustomerRepository customerRepository;
    private final RiskService riskService;
    private final AccountRepository accountRepository;
    private final NotificationService notificationService;

    public CustomerOnboardingService(
            CustomerRepository customerRepository,
            RiskService riskService,
            AccountRepository accountRepository,
            NotificationService notificationService) {
        this.customerRepository = customerRepository;
        this.riskService = riskService;
        this.accountRepository = accountRepository;
        this.notificationService = notificationService;
    }

    public OnboardingResult onboard(Customer customer) {
        if (customer == null) {
            return OnboardingResult.rejected("CUSTOMER_REQUIRED");
        }

        if (customer.getAge() < MINIMUM_AGE) {
            return OnboardingResult.rejected("MINIMUM_AGE");
        }

        if (!"ACTIVE".equals(customer.getStatus())) {
            return OnboardingResult.rejected("CUSTOMER_NOT_ACTIVE");
        }

        int riskScore = riskService.calculateScore(customer);

        if (riskScore >= HIGH_RISK_SCORE) {
            return OnboardingResult.rejected("HIGH_RISK");
        }

        if (customer.getInitialDeposit() > MANUAL_REVIEW_AMOUNT) {
            notificationService.notifyManualReview(customer);
            return OnboardingResult.manualReview("AMOUNT_REQUIRES_REVIEW");
        }

        Account account = accountRepository.createAccount(customer);
        notificationService.notifyAccountCreated(customer, account);

        return OnboardingResult.approved(account.getId());
    }
}
