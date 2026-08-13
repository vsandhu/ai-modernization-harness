package legacy;

public class Customer {
    private final String id;
    private final String status;
    private final int age;
    private final double initialDeposit;

    public Customer(String id, String status, int age, double initialDeposit) {
        this.id = id;
        this.status = status;
        this.age = age;
        this.initialDeposit = initialDeposit;
    }

    public String getId() { return id; }
    public String getStatus() { return status; }
    public int getAge() { return age; }
    public double getInitialDeposit() { return initialDeposit; }
}
