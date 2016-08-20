import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by heshamsalman on 11/30/15.
 */
public class Main {

    public static void main(String[] args) {
        DatabaseManager dbm = DatabaseManager.getInstance();

        Connection conn = dbm.connect();
        if (conn == null) exitWithCode(ErrorCodes.COULD_NOT_CONNECT_ERROR);

        try {
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            exitWithCode(ErrorCodes.AUTO_COMMIT_ERROR);
        }

        // Retrieve user input
        Integer studentIdNumber = getStudentId();
        String term = getTermNumber();

        String studentName = dbm.getStudentName(studentIdNumber, conn);
        if (studentName == null) studentIdNumber = -1;

        printHeader(studentIdNumber, studentName, term);

        ResultSet transcriptData = dbm.getTranscript(studentIdNumber, term, conn);
        Map<String, Double> gradeMap = dbm.getGradeMapping(conn);
        printTranscript(transcriptData, gradeMap);

        try {
            conn.close();
        } catch (SQLException e) {
            exitWithCode(ErrorCodes.COULD_NOT_CLOSE_CONNECTION_ERROR);
        }
    }

    private static void printTranscript(ResultSet rs, Map<String, Double> gradeMap) {
        try {
            boolean valid = true;
            int completedCredits = 0;
            double totalGradePointsEarned = 0.0;
            while (rs.next()) {
                if (valid) {
                    System.out.printf("%-5s%-22s%-9s%-7s%-15s\n", "C#", "Title", "Credits", "Grade", "Points Earned");
                    valid = false;
                }
                String cnum = rs.getString("cnum");
                String title = rs.getString("title");
                String credits = Integer.toString(rs.getInt("credit"));
                String grade = rs.getString("grade");
                String pointsEarned = Double.toString(gradeMap.get(grade));

                if (!grade.equals("") && !grade.equals("W") && !grade.equals("W")) {
                    completedCredits += Integer.parseInt(credits);
                    totalGradePointsEarned += Double.parseDouble(pointsEarned);
                }
                System.out.printf("%-5s%-22s%-9s%-7s%-15s\n", cnum, title, credits, grade, pointsEarned);
            }

            System.out.printf("Total Credits Completed:%d\tGPA: %.2f\n", completedCredits,
                    totalGradePointsEarned / completedCredits);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void printHeader(int id, String name, String term) {
        if (id != -1) {
            System.out.printf("ID: %-5d Name: %-30s Term: %-5s\n", id, name, term);
        } else {
            System.out.printf("ID: Invalid\n");
        }
    }

    private static String getTermNumber() {
        Scanner stdin = new Scanner(System.in);
        String termNumber = null;

        while (termNumber == null || termNumber.length() != 5) {
            System.out.println("Enter the student's term#");
            termNumber = stdin.next();
            if (termNumber.length() != 5) System.out.println("Please enter a valid term#");
        }

        stdin.close();

        return termNumber;
    }

    private static Integer getStudentId() {
        Scanner stdin = new Scanner(System.in);
        Integer studentId = null;

        while (studentId == null) {
            System.out.println("Enter the student's id#");
            try {
                studentId = Integer.parseInt(stdin.next());
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid integer");
            }
        }

        stdin.close();

        return studentId;
    }

    private static void exitWithCode(ErrorCodes code) {
        switch (code) {
            case COULD_NOT_CONNECT_ERROR:
                System.out.println("Could not establish connection.");
                break;
            case AUTO_COMMIT_ERROR:
                System.out.println("Could not set auto-commit off.");
                break;
            case COULD_NOT_CLOSE_CONNECTION_ERROR:
                System.out.println("Could not close connection.");
                break;
            case STUDENT_DOES_NOT_EXIST:
                System.out.println("Student could not be found in the database.");
                break;
        }

        // Ordinal returns the value [0..n-1]
        System.exit(code.ordinal() + 1);
    }

    private enum ErrorCodes {
        COULD_NOT_CONNECT_ERROR,
        AUTO_COMMIT_ERROR,
        COULD_NOT_CLOSE_CONNECTION_ERROR,
        STUDENT_DOES_NOT_EXIST
    }
}
