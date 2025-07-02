public class Stack {
    private int[] stackArray;
    private int top;       // index of the top element
    private int capacity;  // max size of stack

    public Stack(int size) {
        capacity = size;
        stackArray = new int[capacity];
        top = -1;  // stack empty when top == -1
    }

    // Adds element to the top of the stack
    public void push(int element) {
        if (isFull()) {
            System.out.println("Stack Overflow: Cannot push " + element);
            return;
        }
        stackArray[++top] = element;
    }

    // Removes and returns the top element
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow: Cannot pop from empty stack");
            return -1;  // or throw exception
        }
        return stackArray[top--];
    }

    // Returns the top element without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty: Cannot peek");
            return -1;  // or throw exception
        }
        return stackArray[top];
    }

    // Checks if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Returns the current number of elements in the stack
    public int size() {
        return top + 1;
    }

    // Helper method to check if stack is full
    private boolean isFull() {
        return top == capacity - 1;
    }
}
