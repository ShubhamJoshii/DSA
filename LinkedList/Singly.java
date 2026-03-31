package LinkedList;

import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Singly {
    Node head = null;

    void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    void insertAfterElement(int data, int target) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node current = head;
        while (current != null && current.data != target) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Target Not Found");
            return;
        }

        Node newNode = new Node(data);
        newNode.next = current.next;
        current.next = newNode;
    }

    void insertBeforeElement(int data, int target) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.data == target) {
            insertAtBeginning(data);
            return;
        }
        Node current = head;
        while (current.next != null && current.next.data != target) {
            current = current.next;
        }
        if (current.next == null) {
            System.out.println("Target Not Found");
            return;
        }
        Node newNode = new Node(data);
        newNode.next = current.next;
        current.next = newNode;
    }

    void deleteByValue(int key) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.data == key) {
            head = head.next;
            return;
        }

        Node current = head;
        Node prev = null;
        while (current != null && current.data != key) {
            prev = current;
            current = current.next;
        }
        if (current == null) {
            System.out.println("Value not found");
            return;
        }
        prev.next = current.next;
    }

    void display() {
        Node current = head;
        if (current == null) {
            System.out.println("List is empty");
            return;
        }
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    void search(int key) {
        Node current = head;
        int position = 1;

        while (current != null) {
            if (current.data == key) {
                System.out.println("Element found at position: " + position);
                return;
            }
            current = current.next;
            position++;
        }

        System.out.println("Element not found");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Singly list = new Singly();
        int choice;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert After Element");
            System.out.println("4. Insert Before Element");
            System.out.println("5. Delete by Value");
            System.out.println("6. Display");
            System.out.println("7. Search Element");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter data: ");
                    list.insertAtBeginning(sc.nextInt());
                    break;

                case 2:
                    System.out.print("Enter data: ");
                    list.insertAtEnd(sc.nextInt());
                    break;

                case 3:
                    System.out.print("Enter data: ");
                    int data = sc.nextInt();
                    System.out.print("Enter target: ");
                    int target = sc.nextInt();
                    list.insertAfterElement(data, target);
                    break;

                case 4:
                    System.out.print("Enter data: ");
                    data = sc.nextInt();
                    System.out.print("Enter target: ");
                    target = sc.nextInt();
                    list.insertBeforeElement(data, target);
                    break;

                case 5:
                    System.out.print("Enter value to delete: ");
                    list.deleteByValue(sc.nextInt());
                    break;

                case 6:
                    list.display();
                    break;

                case 7:
                    System.out.print("Enter value to search: ");
                    list.search(sc.nextInt());
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 0);

        sc.close();
    }
}