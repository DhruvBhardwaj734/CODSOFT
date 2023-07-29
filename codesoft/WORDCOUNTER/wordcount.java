
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class wordcount {
    private static final Set<String> STOP_WORDS = new HashSet<>(Arrays.asList("the", "and", "in", "is", "it", "a"));



    private static String readFromFile(String filePath) {
        StringBuilder text = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                text.append(line).append("\n");
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return text.toString();

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Word Count!\n");

        System.out.print("Please enter a text or provide a file path to count the words: ");
        String input = scanner.nextLine();

        String text;
        if (isFile(input)) {
            text = readFromFile(input);
        } else {
            text = input;
        }

        
        String[] words = text.split("[\\s\\p{Punct}]+");


        int wordCount = 0;


        for (String word : words) {
            if (!STOP_WORDS.contains(word.toLowerCase())) {
                wordCount++;
            }
        }


        System.out.println("Total word count: " + wordCount);
    }

    private static boolean isFile(String input) {
        return input.matches(".*\\.(txt|csv|dat|log)");
    }

}
