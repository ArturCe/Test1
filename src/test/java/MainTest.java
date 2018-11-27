import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;

public class MainTest {

    private Main main;

    @BeforeMethod
    public void test00() {
        main = new Main();
        Main.main(new String[1]);
    }

    @Test
    public void test01() {
        assertNotNull(main);
    }

    @Test
    public void test02() {
        assertNotNull(main.getObjectList());
    }

    @Test
    public void test03() {
        assertFalse(main.getObjectList().isEmpty());
    }

    @Test
    public void test04() {
        assertNotNull(main.getInputStringList());
    }

    @Test
    public void test05() {
        assertFalse(main.getInputStringList().isEmpty());
    }

    @Test
    public void test06() {
        assertNotNull(main.getOutputStringList());
    }

    @Test
    public void test07() {
        assertFalse(main.getOutputStringList().isEmpty());
    }
}
