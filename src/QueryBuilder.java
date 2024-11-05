import java.util.ArrayList;
import java.util.List;

public interface QueryBuilder {
    String buildQuery();
    QueryBuilder limit(int start, int offset);
    QueryBuilder select(String table, String[] columns);
    QueryBuilder where(String column, String[] operators, Object[] values);
}