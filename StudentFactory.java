package Files;

public class StudentFactory {
    public static Student createStudent(String dataLine) {
        String[] data = dataLine.split(";");
        String id = data[0];
        String firstName = data[1];
        String lastName = data[2];
        int age = Integer.parseInt(data[3]);
        int credits = Integer.parseInt(data[4]);
        boolean isDegreeSeeking = "Y".equals(data[5]);

        if (isDegreeSeeking) {
            boolean hasFinancialAssistance = "Y".equals(data[8]);
            double financialAssistanceAmount = hasFinancialAssistance ? Double.parseDouble(data[9]) : 0.0;
            return new DegreeSeekingStudent(id, firstName, lastName, credits, hasFinancialAssistance, financialAssistanceAmount);
        } else {
            String studentType = data[6];
            if ("C".equals(studentType)) {
                return new CertificateStudent(id, firstName, lastName, credits);
            } else {
                return new SeniorCitizenStudent(id, firstName, lastName, credits);
            }
        }
    }
}
