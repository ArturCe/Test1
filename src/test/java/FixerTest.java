import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FixerTest {

    private static String sep;

    @BeforeMethod
    public void resetIndex() {
        sep = "\t";
        Fixer.resetColumnIndex();
    }

    @Test
    public void test01() {
        Row sp = new Row("fjsdkfjods" + sep + "AAA" + sep + "dasdjasiod", sep);
        Fixer.fixLine(sp, "AAA", "Testy123");
        assertEquals(Fixer.getColumnIndex(), 1);
        assertEquals(sp.getLineParts()[1], "Testy123");
    }

    @Test
    public void test02() {
        Row sp = new Row("fjsdkfjods" + sep + "dasdjasiod" + sep + "AAA", sep);
        Fixer.fixLine(sp, "AAA", "Testy123");
        assertEquals(Fixer.getColumnIndex(), 2);
    }

    @Test
    public void test03() {
        Row sp = new Row("fjsdkfjods" + sep + "AAA" + sep + "dasdjasiod", sep);
        Fixer.fixLine(sp, "AAA", "Testy123");
        assertEquals(Fixer.getColumnIndex(), 1);
    }

    @Test
    public void test04() {
        Row sp = new Row("AAA" + sep + "dasdjasiod" + sep + "AAA", sep);
        Fixer.fixLine(sp, "AAA", "Testy123");
        assertEquals(Fixer.getColumnIndex(), 0);
    }

    @Test
    public void test05() {
        Row sp1 = new Row("eeere" + sep + "Abc" + sep + "ytrytr", sep);
        Row sp2 = new Row("dfsfdsfs" + sep + "gfdb" + sep + "0021", sep);
        Fixer.fixLine(sp1, "Abc", "Def");
        Fixer.fixLine(sp2, "Abc", "Def");
        assertEquals(sp1.getLineParts()[1], "Def");
        assertEquals(sp2.getLineParts()[1], "Def");
        printArray(sp1.getLineParts());
        printArray(sp2.getLineParts());
    }

    @Test
    public void test06() {
        Row sp1 = new Row("eeere" + sep + "Abc" + sep + "ytrytr", sep);
        Row sp2 = new Row("", sep);
        Fixer.fixLine(sp1, "Abc", "Def");
        Fixer.fixLine(sp2, "Abc", "Def");
        assertEquals(sp1.getLineParts()[1], "Def");
        assertEquals(sp2.getLineParts()[0], "");
        printArray(sp1.getLineParts());
        printArray(sp2.getLineParts());
    }

    @Test
    public void test07() {
        Row sp1 = new Row("", sep);
        Row sp2 = new Row("7eeere" + sep + "Abc" + sep + "ytrytr", sep);
        Fixer.fixLine(sp1, "Abc", "Def");
        Fixer.fixLine(sp2, "Abc", "Def");
        assertEquals(sp1.getLineParts()[0], "");
        assertEquals(sp2.getLineParts()[1], "Def");
        printArray(sp1.getLineParts());
        printArray(sp2.getLineParts());
    }

    @Test
    public void test08() {
        Row sp1 = new Row(null, sep);
        Row sp2 = new Row("eeere8" + sep + "Abc" + sep + "ytrytr", sep);
        Fixer.fixLine(sp1, "Abc", "Def");
        Fixer.fixLine(sp2, "Abc", "Def");
        assertEquals(sp1.getLineParts()[0], "");
        assertEquals(sp2.getLineParts()[1], "Def");
        printArray(sp1.getLineParts());
        printArray(sp2.getLineParts());
    }

    @Test
    public void test09() {
        Row sp1 = new Row("eeere" + sep + "Abc" + sep + "ytrytr9", sep);
        Row sp2 = new Row(null, sep);
        Fixer.fixLine(sp1, "Abc", "Def");
        Fixer.fixLine(sp2, "Abc", "Def");
        assertEquals(sp1.getLineParts()[1], "Def");
        assertEquals(sp2.getLineParts()[0], "");
        printArray(sp1.getLineParts());
        printArray(sp2.getLineParts());
    }

    @Test
    public void test10() {
        Row sp1 = new Row("10eeere" + sep + "Abc" + sep + "ytrytr", sep);
        Row sp2 = new Row("10dfsfdsfs" + sep + "gfdb" + sep + "0021", sep);
        Fixer.fixLine(sp1, "ABC", "Def");
        Fixer.fixLine(sp2, "ABC", "Def");
        printArray(sp1.getLineParts());
        printArray(sp2.getLineParts());
        assertEquals(sp1.getLineParts()[1], "Abc");
        assertEquals(sp2.getLineParts()[1], "gfdb");
    }

    private void printArray(String[] array) {
        StringBuilder sb = new StringBuilder();
        if (array != null) {
            for (String str : array) {
                sb.append(str).append(", ");
            }
        }
        System.out.println(sb);
    }
}
