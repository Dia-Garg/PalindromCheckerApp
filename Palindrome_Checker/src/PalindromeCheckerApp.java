import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Deque;
import java.util.ArrayDeque;

public class PalindromeCheckerApp {

    private static final String APP_NAME = "Palindrome Checker Application";
    private static final String VERSION = "1.0.0";

    public static void main(String[] args) {

        displayWelcomeMessage();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word to check: ");
        String input = scanner.nextLine();

        checkUsingManualReverse(input);      // UC2
        checkUsingStringBuilder(input);      // UC3
        checkUsingCharArray(input);          // UC4
        checkUsingStack(input);              // UC5
        checkUsingQueueAndStack(input);      // UC6
        checkUsingDeque(input);              // UC7

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
    private static void checkUsingManualReverse(String text) {

        String reversed = "";

        for (int i = text.length() - 1; i >= 0; i--) {
            reversed += text.charAt(i);
        }

        printResult("UC2", text, text.equalsIgnoreCase(reversed));
    }

    // ================= UC3 =================
    private static void checkUsingStringBuilder(String text) {

        String reversed = new StringBuilder(text).reverse().toString();

        printResult("UC3", text, text.equalsIgnoreCase(reversed));
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

        printResult("UC4", text, isPalindrome);
    }

    // ================= UC5 =================
    private static void checkUsingStack(String text) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < text.length(); i++) {
            stack.push(Character.toLowerCase(text.charAt(i)));
        }

        boolean isPalindrome = true;

        for (int i = 0; i < text.length(); i++) {
            if (Character.toLowerCase(text.charAt(i)) != stack.pop()) {
                isPalindrome = false;
                break;
            }
        }

        printResult("UC5", text, isPalindrome);
    }

    // ================= UC6 =================
    private static void checkUsingQueueAndStack(String text) {

        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        for (int i = 0; i < text.length(); i++) {
            char ch = Character.toLowerCase(text.charAt(i));
            stack.push(ch);
            queue.add(ch);
        }

        boolean isPalindrome = true;

        while (!queue.isEmpty()) {
            if (!queue.remove().equals(stack.pop())) {
                isPalindrome = false;
                break;
            }
        }

        printResult("UC6", text, isPalindrome);
    }

    // ================= UC7 =================
    private static void checkUsingDeque(String text) {

        Deque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < text.length(); i++) {
            deque.addLast(Character.toLowerCase(text.charAt(i)));
        }

        boolean isPalindrome = true;

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                isPalindrome = false;
                break;
            }
        }

        printResult("UC7", text, isPalindrome);
    }

    // Common result method
    private static void printResult(String uc, String text, boolean result) {

        if (result) {
            System.out.println(uc + " Result: \"" + text + "\" is a Palindrome.\n");
        } else {
            System.out.println(uc + " Result: \"" + text + "\" is NOT a Palindrome.\n");
        }
    }
}