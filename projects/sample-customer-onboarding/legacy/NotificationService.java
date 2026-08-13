package legacy;

public interface NotificationService {
    void notifyManualReview(Customer customer);
    void notifyAccountCreated(Customer customer, Account account);
}
