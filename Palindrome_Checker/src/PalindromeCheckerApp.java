import java.util.Scanner;

public class PalindromeCheckerApp {

    // Application constants
    private static final String APP_NAME = "Palindrome Checker Application";
    private static final String VERSION = "1.0.0";

    public static void main(String[] args) {

        displayWelcomeMessage();

        // Take input once
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word to check: ");
        String input = scanner.nextLine();

        // Call all methods using same input
        checkUsingReverse(input);
        checkUsingStringBuilder(input);
        checkUsingCharArray(input);

        scanner.close();

        System.out.println("\nProgram execution completed.");
    }

    // ================= UC1 =================
    private static void displayWelcomeMessage() {
        System.out.println("===========================================");
        System.out.println("        " + APP_NAME);
        System.out.println("              Version: " + VERSION);
        System.out.println("===========================================\n");
    }

    // ================= UC2 =================
    private static void checkUsingReverse(String word) {

        String reversed = "";

        for (int i = word.length() - 1; i >= 0; i--) {
            reversed += word.charAt(i);
        }

        if (word.equalsIgnoreCase(reversed)) {
            System.out.println("UC2 Result: \"" + word + "\" is a Palindrome.\n");
        } else {
            System.out.println("UC2 Result: \"" + word + "\" is NOT a Palindrome.\n");
        }
    }

    // ================= UC3 =================
    private static void checkUsingStringBuilder(String original) {

        String reversed = new StringBuilder(original).reverse().toString();

        if (original.equalsIgnoreCase(reversed)) {
            System.out.println("UC3 Result: \"" + original + "\" is a Palindrome.\n");
        } else {
            System.out.println("UC3 Result: \"" + original + "\" is NOT a Palindrome.\n");
        }
    }

    // ================= UC4 =================
    private static void checkUsingCharArray(String text) {

        char[] characters = text.toCharArray();

        int start = 0;
        int end = characters.length - 1;
        boolean isPalindrome = true;

        while (start < end) {

            if (Character.toLowerCase(characters[start]) !=
                    Character.toLowerCase(characters[end])) {
                isPalindrome = false;
                break;
            }

            start++;
            end--;
        }

        if (isPalindrome) {
            System.out.println("UC4 Result: \"" + text + "\" is a Palindrome.");
        } else {
            System.out.println("UC4 Result: \"" + text + "\" is NOT a Palindrome.");
        }
    }
}