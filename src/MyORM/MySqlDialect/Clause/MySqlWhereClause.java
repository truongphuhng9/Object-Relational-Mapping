package MyORM.MySqlDialect.Clause;

import MyORM.Dialect.Clause.WhereClause;
import MyORM.Dialect.Condition.Condition;

public class MySqlWhereClause extends WhereClause {
    public MySqlWhereClause(Condition condition) {
        super(condition);
    }
}
