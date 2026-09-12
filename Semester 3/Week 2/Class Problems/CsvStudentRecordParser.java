public class CsvStudentRecordParser {
    static void parseStudentRecord(String csv) {
        String[] p = csv.split(",", -1);
        System.out.println(p.length == 3
                ? "Name: " + p[0] + " | Roll No: " + p[1] + " | Dept: " + p[2]
                : "Invalid Record");
    }

    public static void main(String[] args) {
        parseStudentRecord("Ananya Verma,RA2211003010123,CSE");
    }
}
