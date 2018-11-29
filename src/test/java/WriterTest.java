import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.*;

public class WriterTest {

    private String fileName;
    private ArrayList<String> list = new ArrayList<>();

    @BeforeMethod
    public void test00() {
        fileName = System.currentTimeMillis() + "_out.txt";
        list.clear();
    }

    @Test
    public void test01() {
        Writer writer = new Writer();
        assertNotNull(writer);
    }

    @Test
    public void test02() {
        list.add("Abcdefgt");
        list.add("Bgfrtrtr");
        list.add("Cjopfjijfidsjofisfds");
        fileName = "0" + fileName;
        Writer.writeFile(fileName, list);
        assertFalse(Writer.getPrintWriter().checkError());
    }

    @Test
    public void test03() {
        boolean isException = false;
        list.add("Abcdefgt");
        list.add("Bgfrtrtr");
        list.add("Cjopfjijfidsjofisfds");
        fileName = "1" + fileName;
        try {
            Writer.writeFile(fileName, list);
        } catch (Exception e) {
            isException = true;
        }
        assertFalse(isException);
    }
}
