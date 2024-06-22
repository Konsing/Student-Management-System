package Files;

public class DegreeSeekingStudent implements Student {
    private String id;
    private String firstName;
    private String lastName;
    private int credits;
    private boolean hasFinancialAssistance;
    private double financialAssistanceAmount;

    public DegreeSeekingStudent(String id, String firstName, String lastName, int credits, boolean hasFinancialAssistance, double financialAssistanceAmount) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.credits = credits;
        this.hasFinancialAssistance = hasFinancialAssistance;
        this.financialAssistanceAmount = financialAssistanceAmount;
    }

    public boolean hasFinancialAssistance() {
        return this.hasFinancialAssistance;
    }

    @Override
    public int computeFees() {
        int baseFee = 150;
        int perCreditFee = 275;
        int fee = baseFee + (Math.min(this.credits, 12) * perCreditFee);
        if (hasFinancialAssistance) {
            fee -= financialAssistanceAmount;
        }
        return Math.max(fee, 0);
    }

    @Override
    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    @Override
    public void printData() {
        System.out.println(getFullName() + " (Degree-seeking student): " + computeFees() + " fees assessed.");
    }
}
