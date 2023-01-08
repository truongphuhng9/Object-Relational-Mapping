package MyORM.MySqlDialect.Clause;

import MyORM.Dialect.Clause.InsertClause;

public class MySqlInsertClause extends InsertClause {
    public MySqlInsertClause(String table, String... columns) {
        super(table, columns);
    }
}
