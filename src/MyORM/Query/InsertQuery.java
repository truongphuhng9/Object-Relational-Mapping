package MyORM.Query;

import MyORM.Dialect.Clause.InsertClause;
import MyORM.Dialect.Clause.ValuesClause;

public class InsertQuery extends Query{
    public InsertQuery() {}
    public InsertQuery insert_into(String table, String... columns) {
        InsertClause insert = new InsertClause(table, columns);
        addClause(insert);
        return this;
    }

    public InsertQuery values(String... vls) {
        ValuesClause values = new ValuesClause(vls);
        addClause(values);
        return this;
    }
}
