import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Start typing, hit Enter to submit: ");
        String output = scanner.nextLine();

        FileWriter outputStream = null;

        try {
            outputStream = new FileWriter("draft.txt");
            outputStream.write(output);
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }
}