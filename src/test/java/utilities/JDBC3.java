package utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBC3 {
    public static void main(String[] args) throws SQLException {
        // create connection:
        Connection cnn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/HR_Production",
                "postgres",
                "Admin");

        //statement
        Statement stt=cnn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        String query="select * from employees";
        ResultSet rs =stt.executeQuery(query);
        ResultSetMetaData rsMeta=rs.getMetaData();
        List<Map<String, Object>> tableData=new ArrayList<>();
        while(rs.next()){
            Map<String, Object> rowData = new HashMap<>();
            for (int order = 1; order <= rsMeta.getColumnCount(); order++){
                rowData.put(rsMeta.getColumnName(order),rs.getString(rsMeta.getColumnName(order))); }
            tableData.add(rowData);
        }
        System.out.println(tableData);

        //employee fName emp_id 100
  findEmployeeWithEmpId(tableData,100);

        //find emp's email for given Fname
 //  findEmployeeEmailWithEmpFname(tableData,"Aigul");

    }

    private static void findEmployeeEmailWithEmpFname(List<Map<String, Object>> tableData, String name) {
        for (Map row: tableData){
            if(row.get("first_name").toString().equals(name)){
                System.out.println(row.get("email"));
                break;
            }
        }
        System.out.println("Finished");
    }

    private static void findEmployeeWithEmpId(List<Map<String, Object>> tableData, int id) {
        for (Map row:tableData) {
            int emp_id = Integer.parseInt(row.get("employee_id").toString());
            if(emp_id==id){
                System.out.println(row.get("first_name"));
                break;
            }
        }
        System.out.println("Finished");
    }
}
