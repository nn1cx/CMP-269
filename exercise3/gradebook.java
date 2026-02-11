import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class gradebook {

    public static void main(String[] args) {
        String inFile = "students.txt";
        String outFile = "grades_report.txt";

        int token;
        String name;
        int avg;

        PrintWriter outStream = null;
        Scanner inStream = null;
        try {
            inStream = new Scanner(new File(inFile));
            inStream.useDelimiter("\\s+");
            outStream = new PrintWriter(new File(outFile));

            do {
                name = inStream.next();

                avg = 0;

                for (int i = 0; i < 3; i++) {
                    token = Integer.parseInt(inStream.next());
                    avg += token;
                }
                avg = avg / 3;

                
                if (avg > 60) {
                    outStream.println("Student: " + name + " | Average: " + avg);
                }

            } while (inStream.hasNext());

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (NumberFormatException e) {
            System.out.println("Input mismatch");
        }
        finally {
            if (inStream != null) {
                inStream.close();
            }
            if (outStream != null) {
                outStream.close();
            }
            System.out.println("Processing completed");
        }
    }
}
