package utilities;

import org.apache.commons.math3.optim.linear.LinearConstraintSet;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JDBCTest {
    public static void main(String[] args) throws SQLException {
      // create connection:
        Connection cnn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/HR_Production",
                "postgres",
                "Admin");

        //statement
        Statement stt=cnn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);


        //read data
//        ResultSet rs=stt.executeQuery("Select * from jobs");
//        rs.next();
//        rs.next();
//
//        System.out.println(rs.getString("job_title"));
//        System.out.println(rs.getInt(1));
//       // while(rs.next()) System.out.println(rs.getString("job_title"));
//        while(rs.next()){
//            System.out.println(rs.getString("job_title"));
//            System.out.println(rs.getString("min_salary"));




       // }
//    ResultSet rs2=stt.executeQuery("select concat(e.first_name, ' ', e.last_name) as p_full_name, concat(d.first_name, ' ', d.last_name) as d_full_name from employees e, dependents d\n" +
//            "where e.employee_id = d.employee_id");
//            while (rs2.next()) {System.out.println(rs2.getString("p_full_name")+" is a parent of "+rs2.getString("d_full_name"));
//            }
        //print: "fullname of parent" is a parent of "fullname of child"
//        ResultSet rs2=stt.executeQuery("select concat(e.first_name, ' ', e.last_name) as p_full_name, concat(d.first_name, ' ', d.last_name) as d_full_name \n" +
//                "from employees e\n" +
//                "inner join  dependents d\n" +
//                "on e.employee_id = d.employee_id");
//        while (rs2.next()) {System.out.println(rs2.getString("p_full_name")+" is a parent of "+rs2.getString("d_full_name"));
//        }

        //find out if there any emails not ending with @sqltutorial.org
        //we need a query to get emails and put them into rs
        //put those to arraylist
        //find out find out if there any emails not ending with @sqltutorial.org


       // findDifferentEmail(cnn,stt);
        findNullZipcode(cnn,stt);
    }

    private static void findNullZipcode(Connection cnn, Statement stt) throws SQLException {
     ResultSet rs= stt.executeQuery("Select postal_code from locations");
     ArrayList<String> postalCodeList=new ArrayList<>();
     while (rs.next())postalCodeList.add(rs.getString("postal_code"));
        System.out.println(postalCodeList);
      boolean isNullPostalCode=false;
        for (String el:postalCodeList) {
           if(el!=null ) isNullPostalCode=true;
        }
        if(isNullPostalCode) System.out.println("Found");
        else System.out.println("Not found");
    }

    private static void findDifferentEmail(Connection cnn, Statement stt) throws SQLException {
        ResultSet rs = stt.executeQuery("Select email from employees");
        ArrayList<String> emailList = new ArrayList<>();
        while (rs.next()) emailList.add(rs.getString("email"));
        boolean isWrongEmail = false;
        for (String el : emailList) {
            if (!el.endsWith("@sqltutorial.org")) {
                System.out.println(el);
                isWrongEmail = true;
            }
        }
        if (isWrongEmail) System.out.println("Found different email");
        else System.out.println("All emails are the same");
    }
}
