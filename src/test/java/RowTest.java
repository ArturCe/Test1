import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;
import static org.testng.Assert.assertEquals;

public class RowTest {

    @Test
    public void test04() {
        Row sp = new Row("", "\t");
        assertEquals(sp.getLineParts().length, 1);
        assertFalse(sp.isModificationRequired());
    }

    @Test
    public void test05() {
        Row sp = new Row("testy swpodjasjfiods ds das", "\t");
        assertEquals(sp.getLineParts().length, 1);
        assertFalse(sp.isModificationRequired());
    }

    @Test
    public void test06() {
        Row sp = new Row("dfsafsd" + "\t" + "165dsafdsf", "\t");
        assertEquals(sp.getLineParts().length, 2);
        assertTrue(sp.isModificationRequired());
    }

    @Test
    public void test07() {
        Row sp = new Row("\t" + "165dsafdsf", "\t");
        assertEquals(sp.getLineParts().length, 2);
        assertTrue(sp.isModificationRequired());
    }

    @Test
    public void test08() {
        Row sp = new Row("\t" + "165dsafdsf" + "\t", "\t");
        Assert.assertTrue(sp.getLineParts().length > 1);
        assertTrue(sp.isModificationRequired());
    }

    @Test
    public void test09() {
        Row sp = new Row("165dsafdsf" + "\t", "\t");
        assertEquals(sp.getLineParts().length, 1);
        assertFalse(sp.isModificationRequired());
    }

    @Test
    public void test10() {
        Row sp = new Row("\t", "\t");
        assertEquals(sp.getLineParts().length, 1);
        assertFalse(sp.isModificationRequired());
    }

    @Test
    public void test12() {
        Row sp = new Row(null, "\t");
        assertEquals(sp.getLineParts().length, 1);
        assertFalse(sp.isModificationRequired());
    }

    @Test
    public void test13() {
        Row sp = new Row(null, null);
        assertEquals(sp.getLineParts().length, 1);
        assertFalse(sp.isModificationRequired());
    }

    @Test
    public void test14() {
        Row sp = new Row("", null);
        assertEquals(sp.getLineParts().length, 1);
        assertFalse(sp.isModificationRequired());
    }

    @Test
    public void test15() {
        Row sp = new Row("\t", null);
        assertEquals(sp.getLineParts().length, 1);
        assertFalse(sp.isModificationRequired());
    }

    @Test
    public void test16() {
        Row sp = new Row("testy swpodjasjfiods ds das", "\t");
        assertNotNull(sp.getLinePartsAsString());
    }

    @Test
    public void test17() {
        Row sp = new Row("testy swpodjasjfiods ds das", "\t");
        assertTrue(sp.getLinePartsAsString().length() > 0);
    }

    @Test
    public void test18() {
        String text = "testy swpodjasjfiods ds das";
        Row sp = new Row(text, "\t");
        assertEquals(sp.getLinePartsAsString(), text);
    }

    @Test
    public void test19() {
        String separator = "\t";
        String text = "123" + "\t" + "123" + separator + "123";
        System.out.println(text);
        Row sp = new Row(text, separator);
        assertEquals(sp.getLinePartsAsString(), text);
    }

    @Test
    public void test20() {
        String text = "123";
        Row sp = new Row(text, null);
        assertEquals(sp.getLinePartsAsString(), text);
    }

    @Test
    public void test21() {
        String separator = "\t";
        String text = "testy swpodjasjfiods ds das";
        Row sp = new Row(text + separator + text + separator, separator);
        assertEquals(sp.getLinePartsAsString(), text + separator + text);
    }

    @Test
    public void test28() {
        String separator = "\t";
        Row sp = new Row("testy swpodjasjfiods ds das", separator);
        assertEquals(sp.getSeparator(), separator);
    }

    @Test
    public void test29() {
        String separator = null;
        Row sp = new Row("testy swpodjasjfiods ds das", separator);
        assertEquals(sp.getSeparator(), separator);
    }

}
