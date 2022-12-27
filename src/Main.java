import DbConnection.IDbConnection;
import DbConnection.MySqlConnection;
import Query.Clause.*;
import Query.Query;
import com.sun.jdi.event.ClassUnloadEvent;

import java.sql.Connection;
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
        Query q = new Query();
        String sql2 = "SELECT * FROM [user]";
        String sql3 = q.select().from("User");
        String sql = q.insert("Product", "ProductID", "ProductName").values("1", "'Iphone14ProMax'").build();
        System.out.println(sql);
    }
}