package nl.idgis;

import org.junit.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class H2TimeTest {

    private static long startTime;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("@BeforeClass");
        System.out.println("Time: 0 ms");
        startTime = System.currentTimeMillis();
        //Class.forName("org.h2.Driver");
    }

    @Before
    public void beforeTest() {
        System.out.println("@Before");
        System.out.println("Time: " + (System.currentTimeMillis() - startTime) + " ms");
    }

    @Test
    public void test() throws SQLException {
        System.out.println("@Test");
        System.out.println("Time: " + (System.currentTimeMillis() - startTime) + " ms");

        Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
        connection.createStatement();

        System.out.println(connection);
        System.out.println("Time: " + (System.currentTimeMillis() - startTime) + " ms");
    }

    @After
    public void afterTest() {
        System.out.println("@After");
        System.out.println("Time: " + (System.currentTimeMillis() - startTime) + " ms");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("@AfterClass");
        System.out.println("Time: " + (System.currentTimeMillis() - startTime) + " ms");
    }
}
