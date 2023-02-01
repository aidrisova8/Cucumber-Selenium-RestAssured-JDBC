package utilities;

import java.sql.*;
import java.util.ArrayList;

public class JDBC1 {
    public static void main(String[] args) throws SQLException {
        // create connection:
        Connection cnn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/HR_Production",
                "postgres",
                "Admin");

        //statement
        Statement stt=cnn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);


        //read data
        ResultSet rs=stt.executeQuery("Select * from jobs");
//        rs.next();0
//        System.out.println(rs.getString("job_title"));

       // printCountries(stt);
      //  printDepartmentsByCountries(stt);
        updateAllEmails(stt);
    }

    private static void updateAllEmails(Statement stt) throws SQLException {
        String emailQuery="Select email from employees";
        ResultSet rs = stt.executeQuery(emailQuery);
        ArrayList<String> emailList=new ArrayList<>();
        while(rs.next()){
            emailList.add(rs.getString("email"));
        }
        ArrayList<String> newEmailList  = new ArrayList<>();
        for (String email:emailList) {
       newEmailList.add( email.substring(0,email.indexOf('@'))+"@mindtek.edu");
        }
        System.out.println(newEmailList);

        //put db
        String updateQuery="update employees set email = newEmail where employees.email = oldEmail";
        int i=0;
        for(String em: emailList){
            updateQuery="update employees set email= '"+newEmailList.get(i)+"' where employees.email ='"+emailList.get(i)+"'";
             stt.executeUpdate(updateQuery);
            //System.out.println(updateQuery);
            i++;
        }
//        ArrayList<String> emailList = new ArrayList<>();
//        while (rs.next()) emailList.add(rs.getString("email"));
//        String endEmail="@mindtek.edu";
//               ArrayList<String> emailListNew = new ArrayList<>();
//        for(int i=0;i<emailList.size();i++){
//        emailListNew.add(emailList.get(i).substring(0,emailList.get(i).indexOf("@"))+endEmail);}
//        System.out.println(emailListNew);
    }

    private static void printDepartmentsByCountries(Statement stt) throws SQLException {
        ResultSet rs= stt.executeQuery("select l.country_id, count(d.department_name) \n" +
                "from locations l, departments d\n" +
                "where l.location_id=d.location_id\n" +
                "group by l.country_id");
        while(rs.next()){
            System.out.println(rs.getString("country_id") + " -> " + rs.getString("count"));
        }
    }

    private static void printCountries(Statement stt) throws SQLException {
        ResultSet rs= stt.executeQuery("select* from countries");
        int n=1;
        while (rs.next()) {
            System.out.println(n+"->"+rs.getString("country_name"));
            n++;
        }
    }
}
