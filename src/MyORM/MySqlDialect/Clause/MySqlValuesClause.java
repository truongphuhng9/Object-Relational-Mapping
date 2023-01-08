package MyORM.MySqlDialect.Clause;

import MyORM.Dialect.Clause.ValuesClause;

public class MySqlValuesClause extends ValuesClause {
    public MySqlValuesClause(String... columns) {
        super(columns);
    }
}
