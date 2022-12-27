package Query;

import Query.Clause.*;

import java.util.ArrayList;
import java.util.List;

public class Query extends Clause{
    private Clause head;
    private Clause tail;
    private List<Clause> clauses;
    private ClauseFactory clauseFactory;

    public Query(ClauseFactory clauseFactory) {
        this.head = this;
        this.tail = this;
        this.clauses = new ArrayList<>();
        this.clauses.add(this);
        this.clauseFactory = clauseFactory;
    }
    private void addClause(Clause clause) {
        this.tail.setNext(clause);
        this.tail = clause;
        this.clauses.add(clause);
    }

    public Query select() {
        Clause select = this.clauseFactory.createSelectClause();
        this.addClause(select);
        return this;
    }

    public Query from(String tableName) {
        Clause from = this.clauseFactory.createFromClause(tableName);
        this.addClause(from);
        return this;
    }

    public Query insert(String table, String... columns) {
        Clause insert = new InsertClause(table, columns);
        this.addClause(insert);
        return this;
    }

    public Query values(String... vls) {
        Clause values = new ValuesClause(vls);
        this.addClause(values);
        return this;
    }

    @Override
    public String build(String sql) {
        if (tail == this) return "";
        return this.buildNext("");
    }
}
