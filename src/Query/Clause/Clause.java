package Query.Clause;

public abstract class Clause {
    protected String paramsString;
    private Clause next;

    public static Clause link(Clause first, Clause... chain) {
        Clause head = first;
        for (Clause nextInChain: chain) {
            head.next = nextInChain;
            head = nextInChain;
        }
        return first;
    }

    public Clause setNext(Clause next) {
        this.next = next;
        return this;
    }

    public abstract String build(String sql);
    public String build() {
        return this.build("");
    }
    protected String buildNext(String sql) {
        if (next == null) {
            return sql;
        }
        return next.build(sql);
    }
}
