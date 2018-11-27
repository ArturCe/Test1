import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.assertNotNull;

public class WriterTest {

    private String fileName;
    private ArrayList<String> list;

    @BeforeMethod
    public void test00() {
        fileName = System.currentTimeMillis() + ".txt";
    }

    @Test
    public void test01() {
        Writer writer = new Writer();
        assertNotNull(writer);
    }

    @Test
    public void test02() {
        list = new ArrayList<>();
        list.add("fdsfdsfds");
        list.add("fdsdfdsfdsgfsdgfsds");
        Writer.writeFile(fileName, list);
    }
}
