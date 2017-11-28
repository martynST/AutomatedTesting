import org.junit.*;

public class MyClass {

    @BeforeClass
    public static void init() {
        System.out.println("init");
    }

    @Before
    public void setUp() {
        System.out.println("set up");
    }

    @Test
    public void test1() {
        System.out.println("test");
    }

    @After
    public void tearDown() {
        System.out.println("tear down");
    }

    @AfterClass
    public static void destroy() {
        System.out.println("destroy");
    }

}