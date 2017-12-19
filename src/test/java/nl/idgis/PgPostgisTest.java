package nl.idgis;

import com.opentable.db.postgres.embedded.EmbeddedPostgres;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.postgis.DriverWrapper;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Properties;

public class PgPostgisTest {

    private EmbeddedPostgres pg;

    @Before
    public void startDatabase() throws Exception {
        pg = EmbeddedPostgres.start();
    }

    @Test
    public void postgresqlTest() throws Exception {

        Connection connection = pg.getPostgresDatabase().getConnection();

        System.out.println(connection);
        System.out.println(pg.getJdbcUrl("postgres", "postgres"));

        Statement stmnt = connection.createStatement();
        stmnt.execute("CREATE extension postgis");
        stmnt.execute("CREATE TABLE mytable(" +
                "id SERIAL PRIMARY KEY," +
                "geom GEOMETRY(Point, 26910)," +
                "name VARCHAR(128))");
    }

    @After
    public void stopDatabase() throws Exception {
        pg.close();
    }
}
