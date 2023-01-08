package MyORM.MySqlDialect.Clause;

import MyORM.Dialect.Clause.FromClause;

public class MySqlFromClause extends FromClause {
    public MySqlFromClause(String tableName) {
        super(tableName);
    }
}
