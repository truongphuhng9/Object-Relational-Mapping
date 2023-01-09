package MyORM.Dialect.Clause;

import MyORM.Dialect.Clause.Clause;
import MyORM.Dialect.Condition.Condition;

public class HavingClause extends Clause {

    protected String literal="HAVING";

    public HavingClause(Condition condition){
        this.paramsString=condition.buildSql();
    }

    @Override
    public String build(String sql) {
        String sqlStatement = String.join(" ", sql, literal, paramsString);
        return buildNext(sqlStatement);
    }
}
