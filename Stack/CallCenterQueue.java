
 import java.util.Scanner;

public class CallCenterQueue {
    private static final int MAX_SIZE = 100;
    private String[] queue = new String[MAX_SIZE];
    private int front = 0;
    private int rear = 0;

    // a. Add call to queue
    public void addCall(String call) {
        if (rear == MAX_SIZE) {
            System.out.println("Queue is full. Cannot add new call.");
        } else {
            queue[rear] = call;
            rear++;
            System.out.println("Call added to queue: " + call);
        }
    }

    // b. Serve and handle next call
    public void serveCall() {
        if (front == rear) {
            System.out.println("No calls to serve.");
        } else {
            System.out.println("Serving call: " + queue[front]);
            front++;
        }
    }

    // c. Display current queue
    public void displayQueue() {
        if (front == rear) {
            System.out.println("No calls in queue.");
        } else {
            System.out.println("Current Call Queue:");
            for (int i = front; i < rear; i++) {
                System.out.println((i - front + 1) + ". " + queue[i]);
            }
        }
    }

    // d. Number of pending calls
    public void pendingCalls() {
        System.out.println("Number of pending calls: " + (rear - front));
    }

    // e. Main method to run menu
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CallCenterQueue callQueue = new CallCenterQueue();
        int choice;

        do {
            System.out.println("\n--- Call Center Queue System ---");
            System.out.println("1. Add Incoming Call");
            System.out.println("2. Serve Next Call");
            System.out.println("3. Display Call Queue");
            System.out.println("4. Display Pending Calls");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter caller name or number: ");
                    String call = sc.nextLine();
                    callQueue.addCall(call);
                    break;
                case 2:
                    callQueue.serveCall();
                    break;
                case 3:
                    callQueue.displayQueue();
                    break;
                case 4:
                    callQueue.pendingCalls();
                    break;
                case 5:
                    System.out.println("Exiting Call Center Queue System...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}
   

