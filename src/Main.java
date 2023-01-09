import java.util.Collection;
import java.util.Optional;

import MyORM.Dialect.Condition.EqualCondition;
import MyORM.Dialect.DbConnection.IDbConnection;
import MyORM.Dialect.DbConnection.MySqlConnection;
import Entity.Category;
import Entity.Product;
import Entity.User;
import MyORM.Dialect.DbConnection.PostgreSqlConnection;
import MyORM.Dialect.Value.IntegerValue;
import MyORM.Dialect.Value.StringValue;
import MyORM.Query.DeleteQuery;
import MyORM.Query.SelectQuery;
import MyORM.Dialect.Value.FieldValue;
import MyORM.Repository.Repository;
import MyORM.Repository.RepositoryImpl;

public class Main {

	private static void queryUsers(Repository<User, Integer> repos) throws Exception {
		String tableName="users";
		String fields="*";
		SelectQuery q = new SelectQuery();
		String sql = q.select(new FieldValue(fields))
				.from(tableName)
				.where(new EqualCondition(new FieldValue("age"), new StringValue("18")))
				.order_by("phone ASC", "lastname DESC")
				.build();
		System.out.printf("[POSTGRESQL]\nQuery users\nstatement: %s\n\n", sql);
		Collection<User> userList = repos.executeList(sql);
		System.out.printf("[POSTGRESQL]\nQuery users\nresult:\n");
		for (User user: userList){
			if(user==null){
				System.out.printf("NULL\n");
			}
			else{
				System.out.printf("%s\n", user.toString());
			}
		}
		System.out.printf("\n");
	}

	private static void queryProducts(Repository<Product, Integer> repos) throws Exception {
		String tableName="products";
		String fields="* ";
		SelectQuery q = new SelectQuery();
		String sql = q.select(new FieldValue(fields))
				.from(tableName)
				.where(new EqualCondition(new FieldValue("category_id"), new StringValue("100")))
				.order_by("amount DESC")
				.build();
		System.out.printf("[POSTGRESQL]\nQuery products\nstatement: %s\n\n", sql);
		Collection<Product> productList = repos.executeList(sql);
		System.out.printf("[POSTGRESQL]\nQuery products\nresult:\n");
		for (Product product: productList){
			if(product==null){
				System.out.printf("NULL\n");
			}
			else{
				System.out.printf("%s\n", product.toString());
			}
		}
		System.out.printf("\n");
	}

	private static void queryProductsAggregate(Repository<Product, Integer> repos) throws Exception {
		String tableName="products";
		String fields="category_id";
		SelectQuery q = new SelectQuery();
		String sql = q.select(new FieldValue(fields))
				.from(tableName)
				.group_by("category_id")
				.having(new EqualCondition(new FieldValue("category_id"), new IntegerValue(100)))
				.build();
		System.out.printf("[POSTGRESQL]\nQuery products\nstatement: %s\n\n", sql);
		Collection<Product> productList = repos.executeList(sql);
		System.out.printf("[POSTGRESQL]\nQuery products\nresult:\n");
		for (Product product: productList){
			if(product==null){
				System.out.printf("NULL\n");
			}
			else{
				System.out.printf("%s\n", product.toString());
			}
		}
		System.out.printf("\n");
	}

	private static void deleteProduct(Repository<Product, Integer> repos) throws Exception {
		String tableName="products";
		DeleteQuery q=new DeleteQuery();

	}

	public static void testPostgreSql() throws Exception{
		IDbConnection db= PostgreSqlConnection.getInstance();
		db.connect("localhost", 5432, "design_pattern", "postgres", "nvmt123456");
		Repository<User, Integer> repos = new RepositoryImpl<>(User.class, Integer.class);
		repos.setDbConn(db);

		queryUsers(repos);

		Repository<Product, Integer> reposProduct = new RepositoryImpl<>(Product.class, Integer.class);
		reposProduct.setDbConn(db);

		queryProducts(reposProduct);
		queryProductsAggregate(reposProduct);

	}

	public static void main(String[] args) throws Exception {
		//testPostgreSql();
		IDbConnection db = MySqlConnection.getInstance();
		db.connect("localhost", 3306, "design_pattern", "root", "root");
		//IDbConnection db = PostgreSqlConnection.getInstance();
		//db.connect("localhost", 5432, "design_pattern", "postgres", "nvmt123456");
		/* Users */
		System.out.println("\n====>>>> Users");
		SelectQuery q = new SelectQuery();
		String sql = q.select()
				.from("users").build();
		System.out.println(sql);

		Repository<User, Integer> repos = new RepositoryImpl<>(User.class, Integer.class);
		repos.setDbConn(db);

		// Get list result
		Collection<User> userList = repos.findAll();
		for (User u : userList) {
			System.out.println(u);
		}

		// Get one result
		User user = repos.execute(sql);
		System.out.println("One user: " + user);

		// 4.Select user with id = 2
		SelectQuery q4 = new SelectQuery();
		Optional<User> user4 = repos.findById(2);
		System.out.println("===========>>User with id 2:");
		System.out.println(user4.get());

//		/* Products */
//		System.out.println("\n====>>>> Products");
//		SelectQuery q2 = new SelectQuery();
//		String sql2 = q2.select()
//				.from("products").build();
//		System.out.println(sql2);
//
//		Repository<Product, Integer> repos2 = new RepositoryImpl<>(Product.class, Integer.class);
//
//		// Get list result
//		Collection<Product> productList = repos2.executeList(sql2);
//		for (Product p : productList) {
//			System.out.println(p);
//		}


//		/* Categories */
//		System.out.println("\n====>>>> Categories");
//		SelectQuery q3 = new SelectQuery();
//		String sql3 = q3.select()
//				.from("categories").build();
//		System.out.println(sql3);
//
//		Repository<Category, Integer> repos3 = new RepositoryImpl<>(Category.class, Integer.class);
//
//		// Get list result
//		Collection<Category> categoryList = repos3.executeList(sql3);
//		for (Category c : categoryList) {
//			System.out.println(c);
//		}


//		/* Customers */
//		SelectQuery q = new SelectQuery();
//		String sql = q.select(new FieldValue("*"))
//				.from("customers").build();
////		String sql = q.select(new FieldValue("*"))
////				.from("customers")
////				.where(new EqualCondition(new FieldValue("customerNumber"), new StringValue("103"))).build();
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