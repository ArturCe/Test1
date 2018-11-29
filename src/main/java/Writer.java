import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Writer {

    private static FileWriter fw = null;
    private static  PrintWriter pw = null;

    private static final String USER_DIR = System.getProperty("user.dir");

    public static void writeFile(String fileName, ArrayList<String> list) {

        String file = USER_DIR + "\\" + fileName;

        try {
            fw = new FileWriter(file);
            pw = new PrintWriter(fw);

            for (String str : list) {
                pw.write(str + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (pw != null) {
                pw.flush();
                pw.close();
            }
        }
    }

    public static PrintWriter getPrintWriter() {
        return pw;
    }
}
