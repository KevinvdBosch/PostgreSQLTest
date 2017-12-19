package nl.idgis;

import com.opentable.db.postgres.embedded.EmbeddedPostgres;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.postgis.DriverWrapper;
import org.postgis.PGgeometry;
import org.postgresql.PGConnection;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Properties;


public class PostgresTest {

    private EmbeddedPostgres pg;

    @Before
    public void startDatabase() throws Exception {
        pg = EmbeddedPostgres.start();
    }

    @Test
    public void postgresqlTest() throws Exception {
        DriverWrapper wrapper = new DriverWrapper();
        Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "postgres");

        //Connection c = wrapper.connect(DriverWrapper.POSTGIS_PROTOCOL + "//localhost:" + pg.getPort() + "/postgres", props);
        Connection c = wrapper.connect(DriverWrapper.POSTGIS_PROTOCOL + "//localhost:5432/postgres", props);

        System.out.println(c);
        System.out.println(pg.getJdbcUrl("postgres", "postgres"));

        Statement stmnt = c.createStatement();
        //stmnt.execute("CREATE extension postgis");
        /*stmnt.execute("CREATE TABLE mytable(" +
                "id SERIAL PRIMARY KEY," +
                "geom GEOMETRY(Point, 26910)," +
                "name VARCHAR(128))");*/
    }

    @After
    public void stopDatabase() throws Exception {
        pg.close();
    }
}
