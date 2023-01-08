package MyORM.Dialect.Clause;

import MyORM.Dialect.Condition.Condition;

public class WhereClause extends Clause {
    protected String literal = "WHERE";
    private Condition condition;

    public WhereClause(Condition condition) {
        this.condition = condition;
    }

    @Override
    public String build(String sql) {
        String newSql = String.join(" ", sql, literal, condition.buildSql());
        return buildNext(newSql);
    }
}
