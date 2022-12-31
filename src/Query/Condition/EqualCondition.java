package Query.Condition;

import Query.Value.Value;

public class EqualCondition implements Condition{
    private Value left;
    private Value right;

    public EqualCondition(Value left, Value right) {
        this.left = left;
        this.right = right;
    }
    @Override
    public String buildSql() {
        return left.toSql() + " = " + right.toSql();
    }
}
