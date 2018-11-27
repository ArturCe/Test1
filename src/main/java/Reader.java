import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Reader {

    private static final String USER_DIR = System.getProperty("user.dir");
    private static final String FILE = USER_DIR + "\\plik.txt";

    public static ArrayList<String> readFileContent() {
        ArrayList<String> aList = new ArrayList<>();
        File file = new File(FILE);

        try {
            List<String> list = Files.readAllLines(file.toPath());
//            for (String str : list) {
//                aList.add(str);
//            }
            aList.addAll(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return aList;
    }

    public static String getFile() {
        return FILE;
    }

    public static String getUserDir() {
        return USER_DIR;
    }
}
