package utils.providers;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.SQLException;

/**
 * Singleton o clase de utilidad que provee una fuente de datos para establecer una conexión con PostgreSQL
 */
public class MysqlDataSourceProvider {

    public static MysqlDataSource dataSource = null;

    private MysqlDataSourceProvider() {}

    /**
     * Establece la fuente de datos con Postgres
     */
    public static MysqlDataSource getDataSource(String URL) {
        dataSource = new MysqlDataSource();
        // Editar con parámetros de la base de datos
        dataSource.setURL(URL);
        dataSource.setUser(System.getenv("DB_USER"));
        dataSource.setPassword(System.getenv("DB_PASS"));
        return dataSource;
    }

    /**
     * @return fuente de datos
     */
    public static MysqlDataSource getDataSource() throws SQLException {
        return dataSource;
    }
}

