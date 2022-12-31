package Query;

import Query.Clause.*;

public interface ClauseFactory {
    public SelectClause createSelectClause();
    public FromClause createFromClause(String table);
    public WhereClause createWhereClause(Clause clause);
    public InsertClause createInsertClause(String table, String... columns);
    public ValuesClause createValuesClause(String... values);
    public UpdateClause createUpdateClause();
}
