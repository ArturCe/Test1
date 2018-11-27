import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class ReaderTest {

    Reader reader;

    @BeforeMethod
    public void test01() {
        reader = new Reader();
    }

    @Test
    public void test02() {
        Assert.assertNotNull(reader);
    }

    @Test
    public void test03() {
        Assert.assertTrue(Reader.getUserDir().length() > 0);
    }

    @Test
    public void test04() {
        Assert.assertTrue(Reader.getFile().length() > 0);
    }

    @Ignore
    @Test(expectedExceptions = {FileNotFoundException.class, IOException.class})
    public void test05() throws FileNotFoundException {
        Reader.readFileContent();
    }

    @Test
    public void test06() {
        ArrayList<String> list = Reader.readFileContent();
        Assert.assertFalse(list.isEmpty());
    }

    @Test
    public void test07() {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> list = Reader.readFileContent();
        for (String s : list) {
            sb.append(s);
        }
        Assert.assertTrue(sb.toString().length() > 0);
    }
}
