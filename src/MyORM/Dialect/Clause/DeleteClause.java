package MyORM.Dialect.Clause;

public class DeleteClause extends Clause {
    protected String literal = "DELETE FROM";

    public DeleteClause(String table) {
        this.paramsString = table;
    }
    @Override
    public String build(String sql) {
        String newSql = String.join(" ", sql, this.literal, paramsString);
        return buildNext(newSql);
    }
}
