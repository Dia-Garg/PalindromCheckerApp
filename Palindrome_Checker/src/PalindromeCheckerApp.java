import java.util.*;

public class PalindromeCheckerApp {

    private static final String APP_NAME = "Palindrome Checker Application";
    private static final String VERSION = "3.0.0";

    public static void main(String[] args) {

        displayWelcomeMessage();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word to check: ");
        String input = scanner.nextLine();
        System.out.println();

        checkUsingReverseLoop(input);          // UC2 & UC3
        checkUsingCharArray(input);            // UC4
        checkUsingStack(input);                // UC5
        checkUsingQueueAndStack(input);        // UC6
        checkUsingDeque(input);                // UC7
        checkUsingLinkedList(input);           // UC8
        checkUsingRecursion(input);            // UC9

        System.out.println("\nProgram execution completed.");
        scanner.close();
    }

    // ================= UC1 =================
    private static void displayWelcomeMessage() {
        System.out.println("===========================================");
        System.out.println("        " + APP_NAME);
        System.out.println("              Version: " + VERSION);
        System.out.println("===========================================\n");
    }

    // ================= UC2 & UC3 =================
    private static void checkUsingReverseLoop(String text) {

        String reversed = "";

        for (int i = text.length() - 1; i >= 0; i--) {
            reversed += text.charAt(i);
        }

        printResult("UC2/UC3 (Reverse Loop)", text, text.equals(reversed));
    }

    // ================= UC4 =================
    private static void checkUsingCharArray(String text) {

        char[] arr = text.toCharArray();
        int start = 0;
        int end = arr.length - 1;
        boolean isPalindrome = true;

        while (start < end) {
            if (arr[start] != arr[end]) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        printResult("UC4 (Char Array)", text, isPalindrome);
    }

    // ================= UC5 =================
    private static void checkUsingStack(String text) {

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

        printResult("UC5 (Stack)", text, isPalindrome);
    }

    // ================= UC6 =================
    private static void checkUsingQueueAndStack(String text) {

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

        printResult("UC6 (Queue + Stack)", text, isPalindrome);
    }

    // ================= UC7 =================
    private static void checkUsingDeque(String text) {

        Deque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < text.length(); i++) {
            deque.addLast(text.charAt(i));
        }

        boolean isPalindrome = true;

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                isPalindrome = false;
                break;
            }
        }

        printResult("UC7 (Deque)", text, isPalindrome);
    }

    // ================= UC8 =================
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
        }
    }

    private static void checkUsingLinkedList(String text) {

        Node head = createLinkedList(text);
        boolean result = isPalindromeLinkedList(head);

        printResult("UC8 (Linked List)", text, result);
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

        while (head != null) {
            Node next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }

    // ================= UC9 =================
    private static void checkUsingRecursion(String text) {

        boolean result = isPalindromeRecursive(text, 0, text.length() - 1);

        printResult("UC9 (Recursion)", text, result);
    }

    private static boolean isPalindromeRecursive(String text, int start, int end) {

        if (start >= end)
            return true;

        if (text.charAt(start) != text.charAt(end))
            return false;

        return isPalindromeRecursive(text, start + 1, end - 1);
    }

    // ================= Common Printer =================
    private static void printResult(String method, String text, boolean result) {

        if (result)
            System.out.println(method + " → \"" + text + "\" is a Palindrome.");
        else
            System.out.println(method + " → \"" + text + "\" is NOT a Palindrome.");
    }
}