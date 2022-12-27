package Query.Clause;

public class AndClause extends Clause{
    protected String literal = "AND";
    protected String left;
    protected String right;

    public AndClause(String left, String right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String build(String sql) {
        String newSql = String.join(" ", sql, this.left, this.literal, this.right);
        return buildNext(newSql);
    }
}
