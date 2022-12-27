package Query.Clause;

public class FromClause extends Clause {
    protected String literal = "FROM";
    public FromClause(String tableName) {
        this.paramsString = tableName;
    }

    @Override
    public String build(String sql) {
        String newSql = String.join(" ", sql, this.literal, paramsString);
        return buildNext(newSql);
    }
}
