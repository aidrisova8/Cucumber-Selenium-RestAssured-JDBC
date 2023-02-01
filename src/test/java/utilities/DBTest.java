package utilities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DBTest {
    public static void main(String[] args) throws SQLException {
DB db=new DB();

//        String query="insert into countries values ('BR', 'Brazil', 2)";
//        db.runInsertQuery(query);

//        String query="delete from countries where country_id='BR'";
//        db.runDeleteQuery(query);

//    String query= "Update employees Set email='test@gmail.com' where employee_id = 100";
//    db.runUpdateQuery(query);


        ArrayList<String> columnNames=new ArrayList<>();
        columnNames.add("first_name");
        columnNames.add("last_name");
        columnNames.add("phone_number");

 ResultSet rs=db.runSelectQuery(columnNames,"employees");
 while (rs.next()) System.out.println(rs.getString("first_name")+" "+rs.getString("phone_number"));


// List<Map<String,Object>> list=  db.getTableForQuery(q);
//        System.out.println(list);


    }
}
