package MyORM.Repository;

import java.util.Collection;
import java.util.Optional;

import MyORM.Dialect.DbConnection.IDbConnection;

public interface Repository<T, ID> {
	public Collection<T> findAll() throws Exception;
	Optional<T> findById(ID id) throws Exception;
	Optional<T> findBy(String... columns);
	public Collection<T> executeList(String query) throws Exception;
	public T execute(String query) throws Exception;
	public void setDbConn(IDbConnection dbConn);
}
