import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner prompt = new Scanner(System.in);
        System.out.print("Enter file name: ");
        String file = prompt.nextLine();
        System.out.print("Enter character to count: ");
        char character = prompt.nextLine().charAt(0);
        int found = 0;
        try {
            found = count(file, character);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Result: " + found);
    }

    private static int count(String file, char character) throws IOException {
        int found = 0;
        try (BufferedReader inputStream = new BufferedReader(new FileReader(file))) {
            int c;
            while ((c = inputStream.read()) != -1) {
                if (c == character) {
                    found++;
                }
            }
        }
        return found;
    }
}