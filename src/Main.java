import Query.Condition.EqualCondition;
import Query.Query.Query;
import Query.Query.SelectQuery;
import Query.Value.FieldValue;
import Query.Value.IntegerValue;
import Query.Value.StringValue;
import Query.Value.Value;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
//        IDbConnection db = MySqlConnection.getInstance();
//        db.connect("localhost", 3306, "mydb", "root", "123456");
//        Connection conn = db.getConnection();
//
//        if (conn != null && !conn.isClosed()) {
//            System.out.println("Connected to MySqlDB via Bounded class");
//        }




        String[] cols = {"ProductId", "ProductName"};
        String[] vals = {"1", "'Iphone promax'"};
        SelectQuery q = new SelectQuery();
        String sql =
                q.select(new FieldValue("UserId"))
                .from("User")
                .where(new EqualCondition(new FieldValue("Name"), new StringValue("Truong Phu Hung")))
                .build();
        System.out.println(sql);
    }
}