package legacy;

public class OnboardingResult {
    private final String status;
    private final String reason;

    private OnboardingResult(String status, String reason) {
        this.status = status;
        this.reason = reason;
    }

    public static OnboardingResult rejected(String reason) {
        return new OnboardingResult("REJECTED", reason);
    }

    public static OnboardingResult manualReview(String reason) {
        return new OnboardingResult("MANUAL_REVIEW", reason);
    }

    public static OnboardingResult approved(String accountId) {
        return new OnboardingResult("APPROVED", accountId);
    }

    public String getStatus() { return status; }
    public String getReason() { return reason; }
}
