package MyORM.Query;

import MyORM.Dialect.Clause.DeleteClause;
import MyORM.Dialect.Clause.FromClause;
import MyORM.Dialect.Clause.WhereClause;
import MyORM.Dialect.Condition.Condition;
import MyORM.Query.Query;

public class DeleteQuery extends Query {

    public DeleteQuery(){

    }

    public DeleteQuery delete(){
        DeleteClause deleteClause=new DeleteClause();
        addClause(deleteClause);
        return this;
    }

    public DeleteQuery from(String tableName){
        FromClause fromClause=new FromClause(tableName);
        addClause(fromClause);
        return this;
    }

    public DeleteQuery where(Condition condition){
        WhereClause whereClause=new WhereClause(condition);
        addClause(whereClause);
        return this;
    }
}
