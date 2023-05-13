import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        boolean isExit = false;
        while (!isExit) {
            System.out.println();
            System.out.println("=".repeat(10) + "Writing to a text file" + "=".repeat(10));
            System.out.println("""
                    (W)rite now
                    (R)ead the result
                    (E)xit""");
            System.out.print("Enter your selection: ");
            String selection = scanner.nextLine();
            switch (selection.toUpperCase()) {
                case "W" -> {
                    System.out.println();
                    System.out.println("-".repeat(10) + " Write now " + "-".repeat(10));
                    System.out.print("Start typing (hit Enter to submit): ");
                    String output = scanner.nextLine();
                    try (FileWriter outputStream = new FileWriter("draft.txt")) {
                        outputStream.write(output);
                    }
                }
                case "R" -> {
                    System.out.println();
                    System.out.println("-".repeat(10) + " Read the result " + "-".repeat(10));
                    try (FileReader inputStream = new FileReader("draft.txt")) {
                        Scanner reader = new Scanner(inputStream);
                        System.out.println(reader.nextLine());
                    }
                }
                case "E" -> {
                    isExit = true;
                }
            }
        }
    }
}