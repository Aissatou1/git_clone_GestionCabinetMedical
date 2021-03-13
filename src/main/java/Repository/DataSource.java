package Repository;

import java.sql.Connection;

public interface DataSource {
    public Connection createConnection();

}
