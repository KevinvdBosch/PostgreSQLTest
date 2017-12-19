package nl.idgis;

import com.opentable.db.postgres.embedded.EmbeddedPostgres;
import com.opentable.db.postgres.junit.EmbeddedPostgresRules;
import com.opentable.db.postgres.junit.SingleInstancePostgresRule;
import org.junit.*;

import java.sql.Connection;
import java.sql.SQLException;

public class EmbeddedPostgresTimeTest {

    @Rule
    public SingleInstancePostgresRule pg = EmbeddedPostgresRules.singleInstance();

    private static long startTime;

    @BeforeClass
    public static void startDb() {
        System.out.println("@BeforeClass");
        System.out.println("Time: 0 ms");
        startTime = System.currentTimeMillis();
    }

    @Before
    public void initTest() {
        System.out.println("@Before");
        System.out.println("Time: " + (System.currentTimeMillis() - startTime) + " ms");
    }

    @Test
    public void test() throws SQLException {
        System.out.println("@Test");
        System.out.println("Time: " + (System.currentTimeMillis() - startTime) + " ms");
        Connection connection = pg.getEmbeddedPostgres().getPostgresDatabase().getConnection();
        connection.createStatement();

        System.out.println("Connection: " + pg.getEmbeddedPostgres().getJdbcUrl("postgres", "postgres"));
        System.out.println("Time: " + (System.currentTimeMillis() - startTime) + " ms");
    }

    @After
    public void afterTest() {
        System.out.println("@After");
        System.out.println("Time: " + (System.currentTimeMillis() - startTime) + " ms");
    }

    @AfterClass
    public static void stopDb() {
        System.out.println("@AfterClass");
        System.out.println("Time: " + (System.currentTimeMillis() - startTime) + " ms");
    }
}
