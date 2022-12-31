import DbConnection.IDbConnection;
import Query.ClauseFactory;

public interface ORMAbstractFactory {
    public IDbConnection createDbConnection();
    public ClauseFactory createClauseFactory();
}
