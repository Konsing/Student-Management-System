package Files;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Report {

    public static String generateReport() {
        StringBuilder reportBuilder = new StringBuilder();
        List<Student> students = new ArrayList<>();
        int degree_nofin_fees = 0;
        int degree_fin_fees = 0;
        int certificate_fees = 0;
        int senior_fees = 0;
        int total_fees = 0;

        reportBuilder.append("Summary of each student's fees assessed: \n\n");

        try {
            List<String> lines = Files.readAllLines(Paths.get("hw2.txt"));
            for (String line : lines) {
                Student student = StudentFactory.createStudent(line);
                students.add(student);

                int student_fee = student.computeFees();
                String student_name = student.getFullName();
                reportBuilder.append(student_name).append(" has $").append(String.format("%,d", student_fee)).append(" fees assessed \n");

                if (student instanceof DegreeSeekingStudent) {
                    if (((DegreeSeekingStudent) student).hasFinancialAssistance()) {
                        degree_fin_fees += student_fee;
                    } else {
                        degree_nofin_fees += student_fee;
                    }
                } else if (student instanceof CertificateStudent) {
                    certificate_fees += student_fee;
                } else if (student instanceof SeniorCitizenStudent) {
                    senior_fees += student_fee;
                }
                total_fees += student_fee;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        reportBuilder.append("\n\nSummary of all student fees assessed: \n\n");
        reportBuilder.append("Degree-seeking students without financial assistance: $").append(String.format("%,d", degree_nofin_fees)).append("\n");
        reportBuilder.append("Degree-seeking students with financial assistance: $").append(String.format("%,d", degree_fin_fees)).append("\n");
        reportBuilder.append("Certificate students: $").append(String.format("%,d", certificate_fees)).append("\n");
        reportBuilder.append("Senior citizens: $").append(String.format("%,d", senior_fees)).append("\n\n");
        reportBuilder.append("Total fees assessed: $").append(String.format("%,d", total_fees));

        return reportBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(generateReport());
    }
}
