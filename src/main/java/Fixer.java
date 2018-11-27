public class Fixer {

    private static final int DEFAULT_VALUE = -1;
    private static int columnIndex = DEFAULT_VALUE;

    public static void fixLine(Row row, String columnName, String newValue) {
        String[] array = row.getLineParts();
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(columnName)) {
                columnIndex = i;
                break;
            }
        }

        if (columnIndex != DEFAULT_VALUE && columnIndex <= array.length - 1) {
            row.getLineParts()[columnIndex] = newValue;
        }
    }

    public static void resetColumnIndex() {
        columnIndex = DEFAULT_VALUE;
    }

    public static int getColumnIndex() {
        return columnIndex;
    }

}
