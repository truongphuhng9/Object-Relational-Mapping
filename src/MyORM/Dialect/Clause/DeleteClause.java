package MyORM.Dialect.Clause;

import MyORM.Dialect.Clause.Clause;

public class DeleteClause extends Clause {
    protected String literal = "DELETE";

    public DeleteClause() {
    }

    @Override
    public String build(String sql) {
        String sqlStatement = String.join(" ", sql, literal);
        return buildNext(sqlStatement);
    }
}
