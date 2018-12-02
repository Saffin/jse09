package cz.ucl.jse.database;

import java.sql.*;

public class JDBCExample {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    // Pokud dostavate vyjimku kvuli casove zone (stava se na Windows), specifikujte
    // v connect stringu casovou zonu - zakomentovany parametr nize.
    // Lepsi je ale nastavit zonu primo v DB:
    // SET GLOBAL time_zone = '+1:00';
    static final String DB_URL = "jdbc:mysql://localhost/college"; //?serverTimezone=Europe/Prague";

    //  Database credentials
    static final String USER = "user";
    static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        try {
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            printAllStudents(conn);
            long maxId = getMaxId(conn);
            insertStudent(conn, maxId);

            conn.close();
        }catch(SQLException se){
            se.printStackTrace();
        }
    }

    private static void insertStudent(Connection conn, long maxId) throws SQLException {
        String sql =
                "insert into student (id, name) " +
                        "values (?, ?)";

        PreparedStatement insertStudent = conn.prepareStatement(sql);
        insertStudent.setLong(1, maxId + 1);
        insertStudent.setString(2, "Jana Nováková");
        insertStudent.executeUpdate();
        insertStudent.close();
    }

    private static long getMaxId(Connection conn) throws SQLException {
        String sql = "SELECT max(id) id FROM student";
        PreparedStatement selectMaxId = conn.prepareStatement(sql);
        ResultSet rs = selectMaxId.executeQuery(sql);

        rs.next();
        long maxId = rs.getLong("id");
        selectMaxId.close();
        return maxId;
    }

    private static void printAllStudents(Connection conn) throws SQLException {
        Statement stmt;
        System.out.println("Creating statement...");
        stmt = conn.createStatement();
        String sql;
        sql = "SELECT id, name FROM student";
        ResultSet rs = stmt.executeQuery(sql);

        while(rs.next()){
            //Retrieve by column name
            int id  = rs.getInt("id");
            String name = rs.getString("name");

            //Display values
            System.out.print("ID: " + id);
            System.out.print(", Name: " + name);
            System.out.println();
        }

        rs.close();
        stmt.close();
    }

}
