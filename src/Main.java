import Query.Condition.EqualCondition;
import Query.Query.SelectQuery;
import Query.Value.FieldValue;
import Query.Value.StringValue;
import Repository.Respository;
import Repository.RespositoryImpl;

import java.util.Collection;

import DbConnection.IDbConnection;
import DbConnection.MySqlConnection;
import Entity.Product;
import Entity.User;

public class Main {
	public static void main(String[] args) throws Exception {
		IDbConnection db = MySqlConnection.getInstance();
		db.connect("localhost", 3306, "design_pattern", "root", null);
		// Connection conn = db.getConnection();
//
//        if (conn != null && !conn.isClosed()) {
//            System.out.println("Connected to MySqlDB via Bounded class");
//        }

//		String[] cols = { "ProductId", "ProductName" };
//		String[] vals = { "1", "'Iphone promax'" };
		
		/* User */
		SelectQuery q = new SelectQuery();
		String sql = q.select(new FieldValue("user_id, firstname"))
				.from("user")
				.where(new EqualCondition(new FieldValue("age"), new StringValue("18"))).build();
		System.out.println(sql);

		Respository<User, Integer> repos = new RespositoryImpl<>(User.class, Integer.class);
		repos.setDbConn(db);

		// Get list result
		Collection<User> userList = repos.executeList(sql);
		for (User u : userList) {
			System.out.println(u);
		}

		// Get one result
		User user = repos.execute(sql);
		System.out.println("One user: " + user);

		
		/* Product */
		SelectQuery qProduct = new SelectQuery();
		String queryStrProduct = qProduct.select(new FieldValue("product_id, amount, product_name"))
				.from("product")
				.where(new EqualCondition(new FieldValue("category"), new StringValue("Dien thoai"))).build();
		System.out.println(queryStrProduct);
		Respository<Product, Integer> reposProduct = new RespositoryImpl<>(Product.class, Integer.class);
		reposProduct.setDbConn(db);

		// Get list product
		Collection<Product> productList = reposProduct.executeList(queryStrProduct);
		for (Product p : productList) {
			System.out.println(p);
		}

		// Get one result
		Product product = reposProduct.execute(queryStrProduct);
		System.out.println("One product: " + product);

	}
}