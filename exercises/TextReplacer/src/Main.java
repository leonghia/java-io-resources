import java.io.*;
import java.util.Scanner;

public class Main {

    private static String replace(String file, String wordToSearch, String wordToReplace) throws IOException {
        BufferedReader inputStream = null;
        String result = "";

        try {
            inputStream = new BufferedReader(new FileReader(file));
            boolean isEOF = false;
            while (!isEOF) {
                String line = inputStream.readLine();
                if (line == null) {
                    isEOF = true;
                    continue;
                }
                if (line.contains(wordToSearch)) {
                    result += line.replaceAll(wordToSearch, wordToReplace);
                }
            }

        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner prompt = new Scanner(System.in);

        System.out.print("Enter file name: ");
        String file = prompt.nextLine();
        System.out.print("Enter word to search: ");
        String wordToSearch = prompt.nextLine();
        System.out.print("Enter word to replace: ");
        String wordToReplace = prompt.nextLine();

        String result = null;
        try {
            result = replace(file, wordToSearch, wordToReplace);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        if (result.isEmpty()) {
            System.out.println("Word not found");
            return;
        }
        try (BufferedWriter outputStream = new BufferedWriter(new FileWriter("file.txt.out"))) {
            outputStream.write(result);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}