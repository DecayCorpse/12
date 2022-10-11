import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        System.out.println("введдите документ");
//        File file1 = new File(sc.nextLine());
        File file1 = new File("DocsNumbers.txt");
        File file2 = new File("InvalidNumbers.txt");
        FileWriter fw = null;
        try {
            fw = new FileWriter(file2, false);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scanner scanner = new Scanner(file1);
        List<String> docLine = new ArrayList<String>();
        while (scanner.hasNextLine()) {
            docLine.add(scanner.nextLine());
        }
        for (String docnumber : docLine) {
            if (!docnumber.startsWith("docnum") && !docnumber.startsWith("contract")) {
                try {
                    fw.write(docnumber + " - Ivalid prefix");
                    fw.append('\n');
                    fw.flush();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (docnumber.length() > 15) {
                try {
                    fw.write(docnumber + " - Ivalid lenght");
                    fw.append('\n');
                    fw.flush();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        System.out.println(docLine);
    }

}