public class Row {

    private String[] lineParts;
    private String linePartsAsString;
    private String separator;
    private boolean modificationRequired = false;

    Row(String line, String separator) {
        this.separator = separator;

        if (line != null && separator != null) {
            if (line.equals(separator) || !line.contains(separator)) {
                lineParts = new String[1];
                lineParts[0] = line;
            } else if (line.contains(separator)) {
                lineParts = line.split(separator);
            }
        } else if (line != null && separator == null) {
            lineParts = new String[1];
            lineParts[0] = line;
        } else {
            lineParts = new String[1];
            lineParts[0] = "";
        }
        setModificationRequired();
    }

    public String[] getLineParts() {
        return lineParts;
    }

    public String getLinePartsAsString() {
        if (lineParts.length > 1) {
            StringBuilder sb = new StringBuilder();
            for (String str : lineParts) {
                sb.append(str).append(separator);
            }
            String str = sb.toString();
            linePartsAsString = str.length() > 1 ? str.substring(0, str.length() -1) : str;
        } else {
            linePartsAsString = lineParts[0];
        }
        return linePartsAsString;
    }

    public String getSeparator() {
        return separator;
    }

    public boolean isModificationRequired() {
        return modificationRequired;
    }

    private void setModificationRequired() {
        if (lineParts.length > 1) {
            modificationRequired = true;
        }
    }
    

}
