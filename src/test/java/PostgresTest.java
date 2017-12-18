import com.opentable.db.postgres.embedded.EmbeddedPostgres;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class PostgresTest {

    private EmbeddedPostgres pg;

    @Before
    public void startDatabase() throws Exception {
        pg = EmbeddedPostgres.start();
    }

    @Test
    public void postgresqlTest() throws Exception {
        Connection c = pg.getPostgresDatabase().getConnection();
        Statement stmnt = c.createStatement();

        //stmnt.execute("CREATE extension postgis");
        stmnt.execute("CREATE TABLE persons(id INTEGER, name TEXT, bedrijf TEXT)");
        stmnt.execute("INSERT INTO persons VALUES(1, 'Kevin', 'IDgis')");
        stmnt.execute("INSERT INTO persons VALUES(1, 'Herman', 'IDgis')");
        stmnt.execute("INSERT INTO persons VALUES(1, 'Michiel', 'IDgis')");
        stmnt.execute("INSERT INTO persons VALUES(1, 'Sandro', 'IDgis')");

        ResultSet rs = stmnt.executeQuery("SELECT * FROM persons");
        while(rs.next()) {
            System.out.println("Name: " + rs.getString("name") + ", bedrijf: " + rs.getString("bedrijf"));
        }
    }

    @After
    public void stopDatabase() throws Exception {
        pg.close();
    }
}
