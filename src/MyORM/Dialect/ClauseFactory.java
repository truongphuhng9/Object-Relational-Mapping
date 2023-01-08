package MyORM.Dialect;

import MyORM.Dialect.Clause.*;
import MyORM.Dialect.Condition.Condition;

public interface ClauseFactory {
    public SelectClause createSelectClause();
    public FromClause createFromClause(String table);
    public WhereClause createWhereClause(Condition condition);
    public InsertClause createInsertClause(String table, String... columns);
    public ValuesClause createValuesClause(String... values);
    public UpdateClause createUpdateClause();
}
