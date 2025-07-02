public class Q2 {
    public class CustomStack {
    private int[] stackArray;
    private int top;
    private int capacity;

    public CustomStack(int size) {
        capacity = size;
        stackArray = new int[capacity];
        top = -1;
    }

    // Adds val to top of stack
    public void push(int val) {
        if (isFull()) {
            System.out.println("Stack is full. Cannot push " + val);
            return;
        }
        stackArray[++top] = val;
    }

    // Removes and returns top element
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop.");
            return -1;
        }
        return stackArray[top--];
    }

    // Returns top element without removing
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot peek.");
            return -1;
        }
        return stackArray[top];
    }

    // Checks if stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Checks if stack is full
    public boolean isFull() {
        return top == capacity - 1;
    }
}

}
