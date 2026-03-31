package LinkedList;

import java.util.Scanner;

class Node {
    Node prev;
    int data;
    Node next;

    Node(int data) {
        this.prev = null;
        this.data = data;
        this.next = null;
    }
}

public class Doubly {
    Node head = null;
    Node tail = null;

    // Insert at beginning
    void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        if (head != null) head.prev = newNode;
        else tail = newNode;
        head = newNode;
    }

    // Insert at end
    void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    // Insert after a given element
    void insertAfterElement(int data, int target) {
        Node current = head;
        while (current != null && current.data != target) current = current.next;
        if (current == null) {
            System.out.println("Target not found");
            return;
        }
        Node newNode = new Node(data);
        newNode.next = current.next;
        newNode.prev = current;
        if (current.next != null) current.next.prev = newNode;
        else tail = newNode;
        current.next = newNode;
    }

    // Insert before a given element
    void insertBeforeElement(int data, int target) {
        Node current = head;
        while (current != null && current.data != target) current = current.next;
        if (current == null) {
            System.out.println("Target not found");
            return;
        }
        Node newNode = new Node(data);
        newNode.next = current;
        newNode.prev = current.prev;
        if (current.prev != null) current.prev.next = newNode;
        else head = newNode;
        current.prev = newNode;
    }

    // Delete by value
    void deleteByValue(int key) {
        Node current = head;
        while (current != null && current.data != key) current = current.next;
        if (current == null) {
            System.out.println("Value not found");
            return;
        }
        if (current.prev != null) current.prev.next = current.next;
        else head = current.next;
        if (current.next != null) current.next.prev = current.prev;
        else tail = current.prev;
    }

    // Search element
    void search(int key) {
        Node current = head;
        int pos = 1;
        while (current != null) {
            if (current.data == key) {
                System.out.println("Element found at position: " + pos);
                return;
            }
            current = current.next;
            pos++;
        }
        System.out.println("Element not found");
    }

    // Display forward
    void displayForward() {
        Node current = head;
        System.out.print("Forward: ");
        if (current == null) { System.out.println("List is empty"); return; }
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Display backward
    void displayBackward() {
        Node current = tail;
        System.out.print("Backward: ");
        if (current == null) { System.out.println("List is empty"); return; }
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.prev;
        }
        System.out.println("null");
    }

    // Main menu
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Doubly list = new Doubly();
        int choice;

        do {
            System.out.println("\n--- DOUBLY LINKED LIST MENU ---");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert After Element");
            System.out.println("4. Insert Before Element");
            System.out.println("5. Delete by Value");
            System.out.println("6. Search Element");
            System.out.println("7. Display Forward");
            System.out.println("8. Display Backward");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            int data, target;
            switch (choice) {
                case 1 -> {
                    System.out.print("Enter data: ");
                    data = sc.nextInt();
                    list.insertAtBeginning(data);
                }
                case 2 -> {
                    System.out.print("Enter data: ");
                    data = sc.nextInt();
                    list.insertAtEnd(data);
                }
                case 3 -> {
                    System.out.print("Enter data to insert: ");
                    data = sc.nextInt();
                    System.out.print("Enter target element: ");
                    target = sc.nextInt();
                    list.insertAfterElement(data, target);
                }
                case 4 -> {
                    System.out.print("Enter data to insert: ");
                    data = sc.nextInt();
                    System.out.print("Enter target element: ");
                    target = sc.nextInt();
                    list.insertBeforeElement(data, target);
                }
                case 5 -> {
                    System.out.print("Enter value to delete: ");
                    data = sc.nextInt();
                    list.deleteByValue(data);
                }
                case 6 -> {
                    System.out.print("Enter value to search: ");
                    data = sc.nextInt();
                    list.search(data);
                }
                case 7 -> list.displayForward();
                case 8 -> list.displayBackward();
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice");
            }
        } while (choice != 0);

        sc.close();
    }
}