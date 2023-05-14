import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Logger {

    private static void write(String file, String text) throws IOException {
        BufferedWriter outputStream = null;

        try {
            outputStream = new BufferedWriter(new FileWriter(file, true));
            outputStream.write(LocalDateTime.now() + " - " + text);
            outputStream.newLine();
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter file name: ");
        String file = scanner.nextLine();
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        try {
            write(file, text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}