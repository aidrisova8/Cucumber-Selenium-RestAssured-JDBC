package utilities;

import java.sql.*;

public class JDBC11 {
    public static void main(String[] args) throws SQLException {
        Connection cnn= DriverManager.getConnection("jdbc:postgresql://localhost:5432/HR_Production",
                "postgres",
                "Admin");

        Statement stt=cnn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet rs=stt.executeQuery("select * from employees");
        while (rs.next()) System.out.println(rs.getString("first_name"));
    }

}
