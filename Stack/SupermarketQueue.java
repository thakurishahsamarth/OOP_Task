
    import java.util.Scanner;

public class SupermarketQueue {
    private String[] queue;
    private int front, rear, size, capacity;

    public SupermarketQueue(int capacity) {
        this.capacity = capacity;
        queue = new String[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Add customer to queue
    public void addCustomer(String customerName) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot add customer.");
            return;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = customerName;
        size++;
        System.out.println(customerName + " added to the queue.");
    }

    // Serve next customer
    public String serveCustomer() {
        if (isEmpty()) {
            System.out.println("Queue is empty. No customer to serve.");
            return null;
        }
        String servedCustomer = queue[front];
        queue[front] = null;
        front = (front + 1) % capacity;
        size--;
        System.out.println(servedCustomer + " has been served.");
        return servedCustomer;
    }

    // Display current queue
    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Current queue: ");
        for (int i = 0; i < size; i++) {
            System.out.print(queue[(front + i) % capacity] + " ");
        }
        System.out.println();
    }

    // Number of customers in queue
    public int queueSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    // Main method to simulate queue management
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SupermarketQueue queue = new SupermarketQueue(10);
        boolean running = true;

        while (running) {
            System.out.println("\n1. Add Customer\n2. Serve Customer\n3. Display Queue\n4. Queue Size\n5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();
                    queue.addCustomer(name);
                    break;
                case 2:
                    queue.serveCustomer();
                    break;
                case 3:
                    queue.displayQueue();
                    break;
                case 4:
                    System.out.println("Number of customers in queue: " + queue.queueSize());
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }
}


