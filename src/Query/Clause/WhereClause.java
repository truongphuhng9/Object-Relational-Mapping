package Query.Clause;

public class WhereClause extends Clause {
    protected String literal = "WHERE";
    private Clause clause;

    public WhereClause(Clause clause) {
        this.clause = clause;
    }
    private String innerBuild() {
        return this.clause.build();
    }

    @Override
    public String build(String sql) {
        String newSql = String.join(" ", sql, literal, innerBuild());
        return buildNext(newSql);
    }
}
