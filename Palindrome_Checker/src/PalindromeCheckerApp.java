import java.util.*;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word or sentence to check: ");
        String input = scanner.nextLine();
        System.out.println();

        // UC3
        palindromeUsingReverse(input);

        // UC4
        palindromeUsingCharArray(input);

        // UC5
        palindromeUsingStack(input);

        // UC13
        performanceComparison(input);

        System.out.println("Program execution completed.");
        scanner.close();
    }

    // ================= UC3 =================
    private static void palindromeUsingReverse(String original) {
        String reversed = "";
        for (int i = original.length() - 1; i >= 0; i--)
            reversed += original.charAt(i);

        System.out.println("UC3 Result: " + original.equals(reversed));
        System.out.println();
    }

    // ================= UC4 =================
    private static void palindromeUsingCharArray(String text) {

        char[] arr = text.toCharArray();
        int start = 0, end = arr.length - 1;
        boolean result = true;

        while (start < end) {
            if (arr[start] != arr[end]) {
                result = false;
                break;
            }
            start++;
            end--;
        }

        System.out.println("UC4 Result: " + result);
        System.out.println();
    }

    // ================= UC5 =================
    private static void palindromeUsingStack(String text) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < text.length(); i++)
            stack.push(text.charAt(i));

        boolean result = true;

        for (int i = 0; i < text.length(); i++)
            if (text.charAt(i) != stack.pop()) {
                result = false;
                break;
            }

        System.out.println("UC5 Result: " + result);
        System.out.println();
    }

    // ================= UC13 =================
    private static void performanceComparison(String text) {

        System.out.println("===== UC13: Performance Comparison =====");

        long start, end;

        // Reverse Loop
        start = System.nanoTime();
        palindromeUsingReverse(text);
        end = System.nanoTime();
        System.out.println("Reverse Loop Time: " + (end - start) + " ns");

        // Char Array
        start = System.nanoTime();
        palindromeUsingCharArray(text);
        end = System.nanoTime();
        System.out.println("Char Array Time: " + (end - start) + " ns");

        // Stack
        start = System.nanoTime();
        palindromeUsingStack(text);
        end = System.nanoTime();
        System.out.println("Stack Time: " + (end - start) + " ns");

        System.out.println("=========================================\n");
    }
}