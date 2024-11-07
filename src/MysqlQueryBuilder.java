import java.util.ArrayList;
import java.util.List;

class MysqlQueryBuilder implements QueryBuilder {
    private String table;
    private String select;
    private String limit;
    private final List<String> where = new ArrayList<>();

    @Override
    public String buildQuery() {
        StringBuilder query = new StringBuilder();
        query.append(select != null ? select : "SELECT * ");
        query.append(" FROM ").append(table);

        if (!where.isEmpty()) {
            query.append(" WHERE ");
            query.append(String.join(" AND ", where));
        }

        if (limit != null) {
            query.append(" ").append(limit);
        }

        return query.toString();
    }

    @Override
    public QueryBuilder limit(int start, int offset) {
        this.limit = "LIMIT " + start + ", " + offset;
        return this;
    }

    @Override
    public QueryBuilder select(String table, String[] columns) {
        this.table = table;
        this.select = "SELECT " + String.join(", ", columns);
        return this;
    }

    @Override
    public QueryBuilder where(String column, String[] operators, Object[] values) {
        for (int i = 0; i < operators.length; i++) {
            String condition = column + " " + operators[i] + " '" + values[i] + "'";
            where.add(condition);
        }
        return this;
    }
}