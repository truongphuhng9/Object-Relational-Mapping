package MyORM.Query;

import MyORM.Dialect.Clause.DeleteClause;
import MyORM.Dialect.Clause.WhereClause;
import MyORM.Dialect.Condition.Condition;

public class DeleteQuery extends Query{
    public DeleteQuery() {}
    public DeleteQuery delete_from(String table) {
        DeleteClause delete = new DeleteClause(table);
        addClause(delete);
        return this;
    }

    public DeleteQuery where(Condition condition) {
        WhereClause where = new WhereClause(condition);
        addClause(where);
        return this;
    }

    public DeleteQuery where(String condition) {
        WhereClause where = new WhereClause(condition);
        addClause(where);
        return this;
    }
}
