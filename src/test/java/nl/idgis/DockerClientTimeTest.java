package nl.idgis;

import nl.idgis.nl.idgis.dockerclient.TestDatabase;
import nl.idgis.nl.idgis.dockerclient.TestDatabaseConfig;
import org.junit.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DockerClientTimeTest {

    private static TestDatabaseConfig testDatabaseConfig;
    private static TestDatabase testDatabase;
    private static long startTime;

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("@BeforeClass");
        System.out.println("Time: 0 ms");
        startTime = System.currentTimeMillis();

        testDatabaseConfig = new TestDatabaseConfig();
        testDatabase = testDatabaseConfig.getTestDatabase();
    }

    @Before
    public void beforeTest() {
        System.out.println("@Before");
        System.out.println("Time: " + (System.currentTimeMillis() - startTime) + " ms");
    }

    @Test
    public void test() throws Exception {
        System.out.println("@Test");
        System.out.println("Time: " + (System.currentTimeMillis() - startTime) + " ms");

        Connection connection = testDatabaseConfig.getDataSource(testDatabase).getConnection();

        System.out.println(connection);
        System.out.println("Time: " + (System.currentTimeMillis() - startTime) + " ms");
    }

    @After
    public void afterTest() {
        System.out.println("@After");
        System.out.println("Time: " + (System.currentTimeMillis() - startTime) + " ms");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("@AfterClass");
        testDatabase.destroy();
        System.out.println("Time: " + (System.currentTimeMillis() - startTime) + " ms");
    }
}
