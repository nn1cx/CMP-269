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


        try (Scanner inStream = new Scanner(new File (inFile));
            PrintWriter outStream = new PrintWriter(new File(outFile));) {
            inStream.useDelimiter("\\s+");

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
            System.out.println("Processing completed");
        }
    }
}
