package MySqlQuery.Clause;

import Query.Clause.InsertClause;

public class MySqlInsertClause extends InsertClause {
    public MySqlInsertClause(String table, String... columns) {
        super(table, columns);
    }
}
