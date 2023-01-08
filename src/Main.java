import java.util.Collection;
import java.util.Optional;

import MyORM.Dialect.DbConnection.IDbConnection;
import MyORM.Dialect.DbConnection.MySqlConnection;
import Entity.Category;
import Entity.Product;
import Entity.User;
import MyORM.Query.SelectQuery;
import MyORM.Dialect.Value.FieldValue;
import MyORM.Repository.Repository;
import MyORM.Repository.RepositoryImpl;

public class Main {
	public static void main(String[] args) throws Exception {
		IDbConnection db = MySqlConnection.getInstance();
		db.connect("localhost", 3306, "design_pattern", "root", "root");
		//IDbConnection db = PostgreSqlConnection.getInstance();
		//db.connect("localhost", 5432, "orm_framework", "postgres", "password");
		/* Users */
		System.out.println("\n====>>>> Users");
		SelectQuery q = new SelectQuery();
		String sql = q.select()
				.from("users").build();
		System.out.println(sql);

		Repository<User, Integer> repos = new RepositoryImpl<>(User.class, Integer.class);
		repos.setDbConn(db);

//		// Get list result
//		Collection<User> userList = repos.findAll();
//		for (User u : userList) {
//			System.out.println(u);
//		}
//
//		// Get one result
//		User user = repos.execute(sql);
//		System.out.println("One user: " + user);

		/* Products */
		System.out.println("\n====>>>> Products");
		SelectQuery q2 = new SelectQuery();
		String sql2 = q2.select(new FieldValue("*"))
				.from("products").build();
		System.out.println(sql2);

		Repository<Product, Integer> repos2 = new RepositoryImpl<>(Product.class, Integer.class);

		// Get list result
		Collection<Product> productList = repos2.executeList(sql2);
		for (Product p : productList) {
			System.out.println(p);
		}

		/* User */
		Repository<User, Integer> repos5 = new RepositoryImpl<>(User.class, Integer.class);
		Optional<User> user5 = repos5.findById(2);
		System.out.println("\n======>>> Find user by ID");
		System.out.println(user5);

		/* Categories */
		System.out.println("\n====>>>> Categories");
		SelectQuery q3 = new SelectQuery();
		String sql3 = q3.select(new FieldValue("*"))
				.from("categories").build();
		System.out.println(sql3);

		Repository<Category, Integer> repos3 = new RepositoryImpl<>(Category.class, Integer.class);

		// Get list result
		Collection<Category> categoryList = repos3.executeList(sql3);
		for (Category c : categoryList) {
			System.out.println(c);
		}
		
		
//		/* Customers */
//		SelectQuery q = new SelectQuery();
//		String sql = q.select(new FieldValue("*"))
//				.from("customers").build();

//		System.out.println(sql);
//
//		Respository<Customer, Integer> repos = new RespositoryImpl<>(Customer.class, Integer.class);
//		repos.setDbConn(db);
//
//		// Get list result
//		Collection<Customer> customerList = repos.executeList(sql);
//		for (Customer c : customerList) {
//			System.out.println(c);
//		}
//
//		// Get one result
//		Customer customer = repos.execute(sql);
//		System.out.println("One customer: " + customer);
//		
//		/* Products */
//		SelectQuery q2 = new SelectQuery();
//		String sql2 = q2.select(new FieldValue("*"))
//				.from("products").build();
//
//		Respository<ProductNew, Integer> repos2 = new RespositoryImpl<>(ProductNew.class, Integer.class);
//
//		// Get list result
//		Collection<ProductNew> productList = repos2.executeList(sql2);
//		System.out.println("\n====>>>> Products");
//		System.out.println(sql2);
//		for (ProductNew p : productList) {
//			System.out.println(p);
//		}
//		
//		/* Products */
//		SelectQuery q3 = new SelectQuery();
//		String sql3 = q3.select(new FieldValue("*"))
//				.from("productLines").build();
//
//		Respository<ProductLine, Integer> repos3 = new RespositoryImpl<>(ProductLine.class, Integer.class);
//
//		// Get list result
//		Collection<ProductLine> productLineList = repos3.executeList(sql3);
//		System.out.println("\n====>>>> ProductLines");
//		System.out.println(sql3);
//		for (ProductLine pl : productLineList) {
//			System.out.println(pl);
//		}
	}
}