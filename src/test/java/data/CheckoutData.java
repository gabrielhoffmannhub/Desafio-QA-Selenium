package data;

public class CheckoutData {

    private final String firstName;
    private final String lastName;
    private final String postalCode;

    private CheckoutData(String firstName, String lastName, String postalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.postalCode = postalCode;
    }

    public static CheckoutData valid() {
        return new CheckoutData("Lucas", "Silva", "90550-030");
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPostalCode() {
        return postalCode;
    }
}
