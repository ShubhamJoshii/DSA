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

public class CircularSingly {
    Node head = null;
    void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            newNode.next = newNode;
            head = newNode;
        } else {
            Node current = head;
            while (current.next != head) {
                current = current.next;
            }
            newNode.next = head;
            current.next = newNode;
            head = newNode;
        }
    }

    void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            newNode.next = newNode;
            head = newNode;
        } else {
            Node current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = newNode;
            newNode.next = head;
        }
    }

    void insertAfterElement(int data, int target) {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        Node current = head;
        do {
            if (current.data == target) {
                Node newNode = new Node(data);
                newNode.next = current.next;
                current.next = newNode;
                return;
            }
            current = current.next;
        } while (current != head);

        System.out.println("Target not found");
    }

    void insertBeforeElement(int data, int target) {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        Node newNode = new Node(data);

        if (head.data == target) {
            insertAtBeginning(data);
            return;
        }

        Node current = head;
        Node prev = null;
        do {
            prev = current;
            current = current.next;
            if (current.data == target) {
                newNode.next = current;
                prev.next = newNode;
                return;
            }
        } while (current != head);

        System.out.println("Target not found");
    }

    void deleteByValue(int key) {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        Node current = head;
        Node prev = null;

        if (head.data == key) {
            Node last = head;
            while (last.next != head) {
                last = last.next;
            }

            if (head.next == head) { // Only one node
                head = null;
            } else {
                head = head.next;
                last.next = head;
            }
            System.out.println(key + " deleted");
            return;
        }

        do {
            prev = current;
            current = current.next;
            if (current.data == key) {
                prev.next = current.next;
                System.out.println(key + " deleted");
                return;
            }
        } while (current != head);

        System.out.println("Element not found");
    }

    void search(int key) {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        Node current = head;
        int pos = 1;
        do {
            if (current.data == key) {
                System.out.println("Element found at position: " + pos);
                return;
            }
            current = current.next;
            pos++;
        } while (current != head);

        System.out.println("Element not found");
    }

    void displayForward() {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }
        Node current = head;
        System.out.print("Circular List: ");
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }

    void displayBackward() {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }
        System.out.print("Circular List (backward): ");
        displayBackwardHelper(head, head);
        System.out.println();
    }

    private void displayBackwardHelper(Node start, Node current) {
        if (current.next != start) {
            displayBackwardHelper(start, current.next);
        }
        System.out.print(current.data + " ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CircularSingly list = new CircularSingly();
        int choice;
        do {
            System.out.println("\n--- CIRCULAR LINKED LIST MENU ---");
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