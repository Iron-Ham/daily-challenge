import oracle.jdbc.OracleDriver;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by heshamsalman on 11/30/15.
 */
public class DatabaseManager {
    private final String URL = "jdbc:oracle:oci:@ORCL2";

    // Private constructor
    private DatabaseManager() {
    }

    public static DatabaseManager getInstance() {
        return DatabaseManagerHolder.INSTANCE;
    }

    /**
     * Creates a connection to the database, and returns the open connection.
     */
    public Connection connect() {
        Connection conn = null;

        try {
            DriverManager.registerDriver(new OracleDriver());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            conn = DriverManager.getConnection(URL);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

    public ResultSet getTranscript(int id, String term, Connection c) {
        Statement stmt = null;
        String query = "SELECT course.cnum, course.title, course.credit, enrollment.grade, grd.ptspercr" +
                " FROM course, enrollment, offering, grd" +
                " WHERE enrollment.secnum = offering.secnum" +
                " AND enrollment.term = " + term +
                " AND enrollment.term = offering.term" +
                " AND grd.lgrd = enrollment.grade";

        try {
            stmt = c.createStatement();
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // TODO: Write the SQL statement to retrieve the grade mappings, store them in map, and return that map.
    public Map<String, Double> getGradeMapping(Connection c) {
        Map<String, Double> gradeMapping = new HashMap<>();


        return gradeMapping;
    }

    public String getStudentName(int id, Connection c) {
        Statement stmt = null;
        String query = "SELECT name " +
                "FROM student " +
                "WHERE id = " + id;

        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            String name = rs.getString("name");
            if (rs.wasNull()) return "Invalid";
            return name;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            c.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Initializes the singleton, using the init-on-demand holder idiom pattern.
     * Has the advantage of being thread-safe without additional language constructs.
     * <p>
     * {@link DatabaseManager.DatabaseManagerHolder} is loaded on the first execution of
     * {@link DatabaseManager#getInstance()} or the first access to {@link DatabaseManagerHolder#INSTANCE}, not before.
     */
    private static class DatabaseManagerHolder {
        private static final DatabaseManager INSTANCE = new DatabaseManager();
    }
}
