package Files;

public class SeniorCitizenStudent implements Student {
    private String id;
    private String firstName;
    private String lastName;
    private int credits;

    public SeniorCitizenStudent(String id, String firstName, String lastName, int credits) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.credits = credits;
    }

    @Override
    public int computeFees() {
        if (this.credits <= 6) {
            return 100;
        } else {
            return 100 + 50 * (this.credits - 6);
        }
    }

    @Override
    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    @Override
    public void printData() {
        System.out.println(getFullName() + " (Senior citizen): " + computeFees() + " fees assessed.");
    }
}
