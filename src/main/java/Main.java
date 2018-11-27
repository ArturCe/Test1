import java.util.ArrayList;

public class Main {

    private static ArrayList<Row> rowObjectList;
    private static ArrayList<String> inputStringList;
    private static ArrayList<String> outputStringList;

    public static void main(String[] args) {

        System.out.println("Start...");
        double startTime = System.currentTimeMillis();

        inputStringList = Reader.readFileContent();
        outputStringList = new ArrayList<>();
        rowObjectList = new ArrayList<>();

        for (String str : inputStringList) {
            Row row = new Row(str, "\t");

            if (row.isModificationRequired()) {
                Fixer.fixLine(row, "kolumna4", "Nowa wartosc");
            }
            rowObjectList.add(row);
            outputStringList.add(row.getLinePartsAsString());
        }

        for (String x : outputStringList) {
            System.out.println(x);
        }

        double endTime = System.currentTimeMillis();
        System.out.println("Executed in: " + (endTime - startTime) + " ms");
    }

    public ArrayList<Row> getObjectList() {
        return rowObjectList;
    }

    public ArrayList<String> getInputStringList() {
        return inputStringList;
    }

    public ArrayList<String> getOutputStringList() {
        return outputStringList;
    }
}
