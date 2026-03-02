import java.util.*;

public class PalindromeCheckerApp {

    private static final String APP_NAME = "Palindrome Checker Application";
    private static final String VERSION = "2.0.0";

    public static void main(String[] args) {

        displayWelcomeMessage();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word to check: ");
        String input = scanner.nextLine();

        System.out.println();

        checkHardcodedPalindrome(input);
        palindromeUsingReverse(input);
        palindromeUsingCharArray(input);
        palindromeUsingStack(input);
        palindromeUsingQueueAndStack(input);
        palindromeUsingDeque(input);
        palindromeUsingLinkedList(input);

        System.out.println("Program execution completed.");
        scanner.close();
    }

    // ================= UC1 =================
    private static void displayWelcomeMessage() {
        System.out.println("===========================================");
        System.out.println("        " + APP_NAME);
        System.out.println("              Version: " + VERSION);
        System.out.println("===========================================\n");
    }

    // ================= UC2 =================
    private static void checkHardcodedPalindrome(String word) {

        String reversed = "";

        for (int i = word.length() - 1; i >= 0; i--) {
            reversed += word.charAt(i);
        }

        printResult("UC2", word, word.equals(reversed));
    }

    // ================= UC3 =================
    private static void palindromeUsingReverse(String original) {

        String reversed = "";

        for (int i = original.length() - 1; i >= 0; i--) {
            reversed += original.charAt(i);
        }

        printResult("UC3", original, original.equals(reversed));
    }

    // ================= UC4 =================
    private static void palindromeUsingCharArray(String text) {

        char[] characters = text.toCharArray();
        int start = 0;
        int end = characters.length - 1;
        boolean isPalindrome = true;

        while (start < end) {
            if (characters[start] != characters[end]) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        printResult("UC4", text, isPalindrome);
    }

    // ================= UC5 =================
    private static void palindromeUsingStack(String text) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < text.length(); i++) {
            stack.push(text.charAt(i));
        }

        boolean isPalindrome = true;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != stack.pop()) {
                isPalindrome = false;
                break;
            }
        }

        printResult("UC5", text, isPalindrome);
    }

    // ================= UC6 =================
    private static void palindromeUsingQueueAndStack(String text) {

        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
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
    private static void palindromeUsingDeque(String text) {

        Deque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < text.length(); i++) {
            deque.addLast(text.charAt(i));
        }

        boolean isPalindrome = true;

        while (deque.size() > 1) {
            char front = deque.removeFirst();
            char rear = deque.removeLast();

            if (front != rear) {
                isPalindrome = false;
                break;
            }
        }

        printResult("UC7", text, isPalindrome);
    }

    // ================= UC8 =================
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
        }
    }

    private static void palindromeUsingLinkedList(String text) {

        Node head = createLinkedList(text);

        boolean result = isPalindromeLinkedList(head);

        printResult("UC8", text, result);
    }

    private static Node createLinkedList(String text) {

        Node head = null;
        Node tail = null;

        for (int i = 0; i < text.length(); i++) {
            Node newNode = new Node(text.charAt(i));

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        return head;
    }

    private static boolean isPalindromeLinkedList(Node head) {

        if (head == null || head.next == null)
            return true;

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node secondHalf = reverseList(slow);
        Node firstHalf = head;

        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data)
                return false;

            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    private static Node reverseList(Node head) {

        Node prev = null;
        Node current = head;

        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    // ================= Common Result Printer =================
    private static void printResult(String uc, String text, boolean isPalindrome) {

        if (isPalindrome) {
            System.out.println(uc + " Result: \"" + text + "\" is a Palindrome.");
        } else {
            System.out.println(uc + " Result: \"" + text + "\" is NOT a Palindrome.");
        }
    }
}