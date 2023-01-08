package MyORM.MySqlDialect;

import MyORM.MySqlDialect.Clause.*;
import MyORM.Dialect.Clause.*;
import MyORM.Dialect.ClauseFactory;
import MyORM.Dialect.Condition.Condition;

public class MySqlClauseFactory implements ClauseFactory {
    @Override
    public SelectClause createSelectClause() {
        return new MySqlSelectClause();
    }

    @Override
    public FromClause createFromClause(String table) {
        return new MySqlFromClause(table);
    }

    @Override
    public WhereClause createWhereClause(Condition condition) {
        return new MySqlWhereClause(condition);
    }

    @Override
    public InsertClause createInsertClause(String table, String... columns) {
        return new MySqlInsertClause(table, columns);
    }

    @Override
    public ValuesClause createValuesClause(String... values) {
        return new MySqlValuesClause(values);
    }

    @Override
    public UpdateClause createUpdateClause() {
        return new MySqlUpdateClause();
    }
}
