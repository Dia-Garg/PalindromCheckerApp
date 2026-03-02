public class PalindromeCheckerApp {

    // Application constants
    private static final String APP_NAME = "Palindrome Checker Application";
    private static final String VERSION = "1.0.0";

    public static void main(String[] args) {

        // UC1: Display Welcome Message
        displayWelcomeMessage();

        // UC2: Print Hardcoded Palindrome Result
        checkHardcodedPalindrome();
    }

    // Method for UC1
    private static void displayWelcomeMessage() {
        System.out.println("===========================================");
        System.out.println("        " + APP_NAME);
        System.out.println("              Version: " + VERSION);
        System.out.println("===========================================");
        System.out.println("Application started successfully!");
        System.out.println();
    }

    // Method for UC2
    private static void checkHardcodedPalindrome() {

        // Hardcoded string (String Literal)
        String word = "madam";

        // Reverse the string manually
        String reversed = "";

        for (int i = word.length() - 1; i >= 0; i--) {
            reversed += word.charAt(i);
        }

        // Conditional check using if-else
        if (word.equals(reversed)) {
            System.out.println("The word \"" + word + "\" is a Palindrome.");
        } else {
            System.out.println("The word \"" + word + "\" is NOT a Palindrome.");
        }

        System.out.println("\nProgram exited successfully.");
    }
}