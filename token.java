import java.util.StringTokenizer;

public class token {
    public static void main(String[] args) {
        String longString = "This is a long string with multiple words and spaces";
        
        // Using StringTokenizer
        System.out.println("Using StringTokenizer:");
        StringTokenizer tokenizer = new StringTokenizer(longString, " .,?!");
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            System.out.println(token);
        }
    }
}
