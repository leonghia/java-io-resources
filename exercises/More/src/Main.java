import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BufferedReader inputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader("sample.txt"));
            Scanner scanner = new Scanner(inputStream);
            int lines = 0;
            int characters = 0;
            while (scanner.hasNext()) {
                String output = scanner.next();
                characters += output.length();
                System.out.print(output + " ");
                if (characters >= 39) {
                    System.out.println();
                    characters = 0;
                    lines++;
                    if (lines % 10 == 0) {
                        System.out.print("Press enter to continue: ");
                        Scanner prompt = new Scanner(System.in);
                        prompt.nextLine();
                    }
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}