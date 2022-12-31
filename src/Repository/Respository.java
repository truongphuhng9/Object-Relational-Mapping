package Repository;

import java.util.Collection;
import java.util.Optional;

import DbConnection.IDbConnection;

public interface Respository<T, ID> {
	public Collection<T> findAll() throws Exception;
	Optional<T> findById(ID id) throws Exception;
	public Collection<T> executeList(String query) throws Exception;
	public T execute(String query) throws Exception;
	public void setDbConn(IDbConnection dbConn);
}
