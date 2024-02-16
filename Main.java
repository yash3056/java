// Class representing a stack data structure
class stack {
    // Initialize top as -1, default size as 10, and an array of integers with default size
    public int top = -1;
    public int defaultsize = 1;
    public[] array = new int[default_size
 
    // Method to push an integer onto the stack
    public void push(int x) {
        // Check if the stack is full
        if (top == default_size - 1) {
            System.out.println("Stack is Full");
            // If the stack is full, do not add the integer and return
            return;
        } else {
            // If the stack is not full, add the integer to the top of the stack
            array[++top] = x;
        }
    }
 
    // Method to pop an integer from the stack
    public int pop() {
        // Check if the stack is empty
        if (top == -1) {
            System.out.println("Stack is Empty");
            // If the stack is empty, return 0
            return 0;
        } else {
            // If the stack is not empty, return the integer at the top of the stack and remove it
            return array[top--];
        }
    }
 
    // Method to view the integer at the top of the stack
    public int peek() {
        // Return the integer at the top of the stack
        return array[this.top];
    }
 
    // Method to check if the stack is empty
    public boolean isEmpty() {
        if (top == -1) {
            // If the stack is empty, return true
            return true;
        } else {
            // If the stack is not empty, return false
            return false;
        }
    }
 
    // Method to check if the stack is full
    public boolean isFull() {
        if (top == default_size - 1) {
            // If the stack is full, return true
            return true;
        } else {
            // If the stack is not full, return false
            return false;
        }
    }
 }
 
 // Main class
 public class Main {
    // Create a stack object
    static stack s = new stack();
 
    // Main method
    public static void main(String[] args) {
        // Push integers onto the stack
        s.push(5);
        s.push(7);
        s.push(8);
        s.push(9);
        s.push(3);
 
        // View the integer at the top of the stack
        s.peek();
 
        System.out.print("The elements in the Stack are : ");
        // Loop through the stack and print each integer
        for (int i = 0; i <= s.top; i++) {
            System.out.print(s.array[i] + " ");
        }
 
        System.out.print("\nThe element popped is " + s.pop());
        System.out.print("\nThe elements in the Stack are : ");
        // Loop through the stack and print each integer
        for (int i = 0; i <= s.top; i++) {
            System.out.print(s.array[i] + " ");
        }
    }
 }