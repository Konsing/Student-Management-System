package Files;

public class CertificateStudent implements Student {
    private String id;
    private String firstName;
    private String lastName;
    private int credits;

    public CertificateStudent(String id, String firstName, String lastName, int credits) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.credits = credits;
    }

    @Override
    public int computeFees() {
        return 700 + 300 * this.credits;
    }

    @Override
    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    @Override
    public void printData() {
        System.out.println(getFullName() + " (Certificate student): " + computeFees() + " fees assessed.");
    }
}
