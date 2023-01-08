package MySqlQuery.Clause;

import Query.Clause.WhereClause;
import Query.Condition.Condition;

public class MySqlWhereClause extends WhereClause {
    public MySqlWhereClause(Condition condition) {
        super(condition);
    }
}
