import java.util.*;

public class PalindromeCheckerApp {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word or sentence to check: ");
        String input = scanner.nextLine();
        System.out.println();

        // UC12
        palindromeUsingStrategyPattern(input);

        System.out.println("Program execution completed.");
        scanner.close();
    }


    // ================= UC12 =================
    private static void palindromeUsingStrategyPattern(String text) {

        PalindromeStrategy stackStrategy = new StackStrategy();
        PalindromeStrategy dequeStrategy = new DequeStrategy();

        System.out.println("UC12 Stack Strategy: " + stackStrategy.check(text));
        System.out.println("UC12 Deque Strategy: " + dequeStrategy.check(text));
        System.out.println();
    }

    interface PalindromeStrategy {
        boolean check(String text);
    }

    static class StackStrategy implements PalindromeStrategy {
        public boolean check(String text) {
            Stack<Character> stack = new Stack<>();
            for (char c : text.toCharArray()) stack.push(c);
            for (char c : text.toCharArray())
                if (c != stack.pop()) return false;
            return true;
        }
    }

    static class DequeStrategy implements PalindromeStrategy {
        public boolean check(String text) {
            Deque<Character> deque = new ArrayDeque<>();
            for (char c : text.toCharArray()) deque.addLast(c);
            while (deque.size() > 1)
                if (deque.removeFirst() != deque.removeLast()) return false;
            return true;
        }
    }
}