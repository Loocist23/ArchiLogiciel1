import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MongoQueryBuilder implements QueryBuilder {
    private String collection;
    private final List<String> selectFields = new ArrayList<>();
    private final List<String> whereConditions = new ArrayList<>();
    private int limit = 0;
    private int offset = 0;

    @Override
    public String buildQuery() {
        StringBuilder query = new StringBuilder();

        // Begin MongoDB Query JSON
        query.append("{ ");

        // Add "find" operation for MongoDB
        query.append("\"find\": \"").append(collection).append("\", ");

        // Add "filter" (WHERE conditions) if any
        if (!whereConditions.isEmpty()) {
            query.append("\"filter\": { ");
            query.append(String.join(", ", whereConditions));
            query.append(" }, ");
        } else {
            query.append("\"filter\": {}, ");
        }

        // Add "projection" (SELECT fields) if any
        if (!selectFields.isEmpty()) {
            query.append("\"projection\": { ");
            for (String field : selectFields) {
                query.append("\"").append(field).append("\": 1, ");
            }
            query.delete(query.length() - 2, query.length()); // remove last comma
            query.append(" }, ");
        }

        // Add "limit" and "skip" (offset) if specified
        if (limit > 0) {
            query.append("\"limit\": ").append(limit).append(", ");
        }
        if (offset > 0) {
            query.append("\"skip\": ").append(offset).append(", ");
        }

        // Remove trailing comma and space
        if (query.charAt(query.length() - 2) == ',') {
            query.delete(query.length() - 2, query.length());
        }

        query.append(" }"); // Close JSON object

        return query.toString();
    }

    @Override
    public QueryBuilder limit(int limit, int offset) {
        this.limit = limit;
        this.offset = offset;
        return this;
    }

    @Override
    public QueryBuilder select(String collection, String[] fields) {
        this.collection = collection;
        Collections.addAll(selectFields, fields);
        return this;
    }

    @Override
    public QueryBuilder where(String column, String[] operators, Object[] values) {
        for (int i = 0; i < operators.length; i++) {
            String condition = "\"" + column + "\": { \"" + operators[i] + "\": \"" + values[i] + "\" }";
            whereConditions.add(condition);
        }
        return this;
    }
}
